
package beSkilled.domail;


public class Student {
    private String id;
    private String name;
    private String email;
    private String psaa;

    public Student() {
    }

    public Student(String id, String name, String email, String psaa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.psaa = psaa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsaa() {
        return psaa;
    }

    public void setPsaa(String psaa) {
        this.psaa = psaa;
    }
    
    
}
