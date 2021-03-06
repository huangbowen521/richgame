package thoughtworks.fixedAssets;

import java.text.DecimalFormat;
import thoughtworks.MapObject;

public class Skyscraper extends Space implements MapObject {
	private final String symbol = "3";
	private final int level = 3;
	private int passToll;
	
	public Skyscraper(int position){
		super(position);
		this.passToll = super.getPassToll() * Integer.parseInt(
				new DecimalFormat("0").format(Math.pow(2, level)));
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getPassToll(){
		return this.passToll;
	}
}
