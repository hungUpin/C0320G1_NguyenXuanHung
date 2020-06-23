public class Calculator {
    private Double number1;
    private Double number2;
    private String calculate;
    public Calculator() {
    }

    public Calculator(Double number1, Double number2, String calculate) {
        this.number1 = number1;
        this.number2 = number2;
        this.calculate = calculate;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public String getCalculate() {
        return calculate;
    }

    public void setCalculate(String calculate) {
        this.calculate = calculate;
    }

    public Double calculate(){
        if(this.getCalculate().equals("Addition")){
            return getNumber1()+getNumber2();
        }
        if(getCalculate().equals("Subtraction")){
            return getNumber1()-getNumber2();
        }
        if(getCalculate().equals("Multiplication")){
            return getNumber1()*getNumber2();
        }
        if (getCalculate().equals("Division")){
            if(getNumber2()==0){
                throw new IllegalArgumentException("Argument 'divisor' is 0");
            } else {
                return getNumber1()/getNumber2();
            }
        }
        return null;
    }
}
