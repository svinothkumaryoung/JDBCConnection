public class EmployeeDetails {
    private int registerNo;
    private String name;
    private String Address;
    private String Gender;
    private String Fathername;
    private String Mothername;
    int age;

    public EmployeeDetails(){

    }
    public EmployeeDetails(int registerNo, String name, String address, String gender, String fathername, String mothername, int age) {
        this.registerNo = registerNo;
        this.name = name;
        Address = address;
        Gender = gender;
        Fathername = fathername;
        Mothername = mothername;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "registerNo=" + registerNo +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Fathername='" + Fathername + '\'' +
                ", Mothername='" + Mothername + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(int registerNo) {
        this.registerNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getFathername() {
        return Fathername;
    }

    public void setFathername(String fathername) {
        Fathername = fathername;
    }

    public String getMothername() {
        return Mothername;
    }

    public void setMothername(String mothername) {
        Mothername = mothername;
    }
}
