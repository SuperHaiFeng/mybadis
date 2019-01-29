package jdbc;

public class Person {
    private int id;
    private String name;
    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "person: id = "+id+"name = "+name;
    }
}
