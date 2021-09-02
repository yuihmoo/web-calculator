package kr.co.nandsoft.example.service;
import kr.co.nandsoft.example.controller.CalculateController;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.IconUIResource;
import java.util.*;

/**
 * @see <p>계산 비즈니스 로직 수행 Object, Service Layer</p>
 */
public class Calculator {

    public static String Calc(List list) {

        String s = String.join("", list);
        LinkedList<Character> opList = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<Character> op2List = new LinkedList<>();
        Stack<Integer> tempList = new Stack<>();
        String num = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '+') {
                numList.add(Integer.parseInt(num));
                opList.add(ch);
                num = "";
                continue;
            } else if (ch == '-') {
                numList.add(Integer.parseInt(num));
                opList.add(ch);
                num = "";
                continue;
            } else if (ch == '*') {
                numList.add(Integer.parseInt(num));
                opList.add(ch);
                num = "";
                continue;
            } else if (ch == '/') {
                numList.add(Integer.parseInt(num));
                opList.add(ch);
                num = "";
                continue;
            }
            num += ch;
            // list에 index 순서 그대로 분류하기
        }
        numList.add(Integer.valueOf(num));// 마지막 숫자 넣기
        tempList.push(numList.poll()); // 처음 숫자 세팅(중요) why? 연산은 항상 앞 뒤에 숫자가 있음

        for (int i = 0; opList.isEmpty() != true; i++) {
            char op = opList.poll();
            if (op == '*') {
                tempList.push( numList.poll() * tempList.pop());
                continue;
            } else if (op == '/') {
                tempList.push(numList.poll() / tempList.pop());
                continue;
            } else if (op == '+') {     // +, - 는 나중에 연산 할거라서 빼줌
                tempList.push(numList.poll());
                op2List.add(op);
                continue;
            } else if (op == '-') {
                tempList.push(numList.poll());
                op2List.add(op);
                continue;
            }
        }
        for (int j = 0; op2List.isEmpty() != true; j++) {
            char op2 = op2List.poll();
            if (op2 == '+') {
                tempList.push(tempList.pop() + tempList.pop());
            } else if (op2 == '-') {
                tempList.push(tempList.pop() - tempList.pop());
            }
        }
        String temp = String.valueOf(tempList.pop());
        return temp;
    }
}
//        numList.add(Integer.valueOf(num));// 마지막 숫자 넣기
//        int i = 0;
//        int j = 0;
//
//        while (i < opList.size()) {
//            char op = opList.pop();
//            if (op == '*') {
//                tempList.add(numList.pop() * numList.pop());
//                continue;
//            } else if (op == '/') {
//                tempList.add(numList.pop() / numList.pop());
//                continue;
//            } else if (op == '+') {
//                op2List.add(op);
//                continue;
//            } else if (op == '-') {
//                op2List.add(op);
//                continue;
//            }
//        }
//
//        while (j < op2List.size()) {
//            char op2 = op2List.pop(); // 두번째 리스트를 연산하기 위한 while문
//            if (op2 == '+') {
//                int temp = tempList.pop();
//                int number = numList.pop();
//                tempList.push(temp + number);
//            }
//            else if (op2 == '-') {
//                int temp = tempList.pop();
//                int number = numList.pop();
//                tempList.push(temp - number);
//            }
//        }
//        System.out.println(tempList);
//    }
//}
//
//        int result = 0;
//        char op2 = op2List.pop(); // 마지막 남은 op를 지금까지의 결과 numList의 두 요소를 연산!
//        if (op2 == '+') {
//            result = numList.pop() + numList.pop();
//        }
//        else if (op2 == '-') {
//            result = numList.pop() - numList.pop();
//        }
//        String result_str = String.valueOf(tempList);
//        while (opList.size() > 0 && opList.contains('*') == true || opList.contains('/') == true) {
//            if (opList.peek() == '*') {
//                opList.pop();
//                int result = numList.pop() * numList.pop();
//                fir_result.add(result);
//                continue;
//            } else if (opList.peek() == '/') {
//                opList.pop();
//                int result = numList.pop() / numList.pop();
//                fir_result.add(result);
//                continue;
//            }
//        }
//        while (opList.size() > 0) {
//            if (opList.peek() == '+') {
//                opList.pop();
//                end = fir_result.poll() + numList.pop();
//            } else if (opList.peek() == '-') {
//                opList.pop();
//                end = fir_result.get(1) + fir_result.get(0);
//            }
//        }
//        System.out.println(end);





    //////////
//
//
//        Map<String, Map<String, String>> operatorMap = new HashMap<>();
//        Map<String, String> map = new HashMap<>();
//        map.put("priority", "0");
//        operatorMap.put("x", map);
//
//        map = new HashMap<>();
//        map.put("priority", "0");
//        operatorMap.put("/", map);
//
//        map = new HashMap<>();
//        map.put("priority", "1");
//        operatorMap.put("+", map);
//
//        map = new HashMap<>();
//        map.put("priority", "1");
//        operatorMap.put("-", map);


