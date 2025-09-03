package category;

public class Category {

	private int id;
	private String name;
    private String icon;
    public int getid() {
		return id;
	}
	public void setid(int cateid) {
		this.id = cateid;
	}
	public String getname() {
		return name;
	}
	public void setname(String catename) {
		this.name = catename;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

    public Category(int cateid, String catename, String icon) {
		super();
		this.id = cateid;
		this.name = catename;
		this.icon = icon;
	}
}
