package org.javcarfer.domain;

public class Paint extends DomainObject{
    private String name;
    private String branch;
    private String code;

    public Paint() { }

    public Paint(int id,String name, String branch, String code) {
        this.id=id;
        this.name = name;
        this.branch = branch;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
