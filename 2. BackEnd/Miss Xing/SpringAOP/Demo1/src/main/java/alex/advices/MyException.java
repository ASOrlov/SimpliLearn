package alex.advices;

public class MyException extends RuntimeException{
private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MyException(String msg) {
        this.msg = msg;
    }


}
