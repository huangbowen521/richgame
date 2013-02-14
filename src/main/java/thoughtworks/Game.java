package thoughtworks;

import java.util.ArrayList;
import java.util.Scanner;

import thoughtworks.players.*;

public class Game {
	private PlayerList playerList;
	//private Map map;
	
	public static final String HINT_OF_START = "��������Ϸ��ʼָ�";
	public static final String ERROR_OF_START = "ָ�����������������Ϸ��ʼָ�";
	public static final String HINT_OF_PLAYER_CHOICE = "��ѡ��2~4λ" +
			"���ظ���ң������ż��ɡ���1.Ǯ���ˣ�2.��������3.��С����" +
			"4.�𱴱�����";
	public static final String HINT_OF_PLAYER_INITIAL = "��������ҳ�ʼ" +
			"�ʽ𣬷�Χ1000~50000��Ĭ��10000����";
	public static final String ERROR_OF_PLAYER_NUMBERS = 
			"��ұ������������������룡";
	
	public static final String START_COMMAND = "rich";
	
	public ArrayList<Player> getPlayers(){
		return playerList.getPlayers();
	}
	
	public void start(){
		System.out.println(HINT_OF_START + "\n");

		while(true){
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			scanner.close();
			
			if(input.matches(START_COMMAND)){
				obtainInputToCreatPlayerList();
		        System.out.println(HINT_OF_PLAYER_INITIAL + "\n");
		        Scanner initialFunds = new Scanner(System.in);
		        Player.INITIAL_FUNDS = initialFunds.nextInt();
		        initialFunds.close();
		        break;
		    }
		    else{
			    System.out.println(ERROR_OF_START + "\n");
		    }
		}
	}
	
	public void obtainInputToCreatPlayerList(){
		System.out.println(HINT_OF_PLAYER_CHOICE + "\n");
		boolean isSuccess;
		do{
			Scanner scanner = new Scanner(System.in);
			String input = scanner.next();
			scanner.close();
			isSuccess = isCreatPlayerListSuccess(input);
		}while(!isSuccess);
	}
	
	public boolean isCreatPlayerListSuccess(String input){
		int[] roleNumberArray = RoleNumberTransfer.parseRoleNumberListToArray(
				RoleNumberTransfer.getRoleNumberListFromInput(input));
		if(RoleNumberTransfer.isNumberOfPlayersWithinTheLimits(roleNumberArray) && 
				RoleNumberTransfer.isRoleNumbersWithinTheLimits(roleNumberArray) && 
				RoleNumberTransfer.isRoleNumbersNotRepeat(roleNumberArray)){
			playerList = new PlayerList(roleNumberArray);
		    return true;
	    }
	    else{
	    	System.out.println(ERROR_OF_PLAYER_NUMBERS + "\n");
	    	return false;
	    }
	}
}
