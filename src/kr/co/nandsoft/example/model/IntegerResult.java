package kr.co.nandsoft.example.model;

/**
 * @see <p>Value Object 또는 Model 또는 Domain</p>
 */
public class IntegerResult {
    private int result;

    public IntegerResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
