package com.jianxian.base.pojo;

public class Test extends User {
    private String price;
    private String base;
    private String constant;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(super.getName()).append('\"');
        sb.append(",\"age\":\"")
                .append(getAge()).append('\"');
        sb.append(",\"phone\":\"")
                .append(getPhone()).append('\"');
        sb.append(",\"mail\":\"")
                .append(getMail()).append('\"');
        sb.append(",\"price\":\"")
                .append(price).append('\"');
        sb.append(",\"base\":\"")
                .append(base).append('\"');
        sb.append(",\"constant\":\"")
                .append(constant).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setName("name");
        test.setBase("base");
        test.setConstant("constant");
        test.setPrice("price");
        System.out.println(test.toString());

    }


}
