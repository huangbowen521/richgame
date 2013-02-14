package thoughtworks.players;

public enum PlayerName {
	Q("Ǯ����",1),A("������",2),S("��С��",3),J("�𱴱�",4);
	
	private String name;
	private int index;  
  
	private PlayerName(String name , int index) { 
	    this.name = name;
		this.index = index;  
	}  

	public static String getPlayerName(int index) {
		for (PlayerName c : PlayerName.values()) {
			if (c.getIndex() == index) {
				return c.getName();  
	        }  
	    }  
	    return null;  
	}
	
	public static String getShortName(int index) {
		for (PlayerName c : PlayerName.values()) {
			if (c.getIndex() == index) {
				return c.toString();  
	        }  
	    }  
	    return null;  
	}
	
    public int getIndex() {  
        return index;  
    } 
    
    public String getName() {  
        return name;  
    }
}
