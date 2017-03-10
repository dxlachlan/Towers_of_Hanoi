//Daniel L. Campbell 
//ITCS 2215
//Towers of Hanoi - Recursive Solution - Using Stack(s)
//2/28/2016

import java.util.*;

public class TohMain {
	
	static int num;
	static int steps;
	
	static Stack<Integer>[] tower = new Stack[4];
	
	public static void main(String[] args){
				
		tower[1] = new Stack<Integer>();
		tower[2] = new Stack<Integer>();
		tower[3] = new Stack<Integer>();
		
		intro();
				
		int numDisks = validate();
		
		num = numDisks;
		
		towersOfHanoi(num);
		
		stats();
	}
	
	public static void intro(){
		System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
		System.out.println("       Welcome to Towers of Hanoi       ");
		System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
		System.out.println("Enter a number of disks (3-7[Inclusive])");
		System.out.println(" ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	}
	
	public static int validate(){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		while (num <= 2 || num >=8){
			System.out.println("You entered an invalid number!");
			System.out.println("Please Try Again! [Must be a number between 3-7 (inclusive)]");
			num = input.nextInt();
			System.out.println("~ validating ~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return num;
	}
	
	public static void stats(){
		System.out.println(" ");
		System.out.println("Towers of Hanoi finished in " + steps + " steps.");
	}
	
	public static void towersOfHanoi(int n){
		for (int d = n; d > 0; d--){	
			tower[1].push(new Integer(d));
		}
		System.out.println(" ~ solving ~ ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//output statement
		displayTest();
		move(n, 1, 3, 2);	
	}
	
	public static void move(int n, int start, int aux, int end){		
		if (n > 0){	
			steps++;
			move(n-1, start, end, aux);
			Integer temp = (Integer)tower[start].pop();
			tower[aux].push(temp);
			System.out.println("");
			System.out.println("Move disk " + temp + " from Tower " + start + " to Tower "+ aux);
			//output statement
			displayTest();
			System.out.println("= = = = = = = = = = = = = = = = = = =");
			move(n-1, end, aux, start);			
		}
	}
		
	public static void displayTest(){
		List<Integer> t1 = new ArrayList<Integer>(tower[1]);
		List<Integer> t2 = new ArrayList<Integer>(tower[2]);
		List<Integer> t3 = new ArrayList<Integer>(tower[3]);
		System.out.println("= = = = = = = = = = = = = = = = =");
		System.out.println("  Tower1  |  Tower2  |  Tower3  |");
		System.out.println("- - - - - - - - - - - - - - - - -");
		for(int i = num - 1; i >=0; i--){
			 String x1 = " ", x2 = " ", x3 = " ";
			try{
				x1 = String.valueOf(tower[1].get(i));
			} catch (Exception e){
			}
			try{
				x2 = String.valueOf(tower[2].get(i));
			}catch (Exception e){
			}
			try{
				x3 = String.valueOf(tower[3].get(i));
			} catch (Exception e){
			}
			System.out.println("    " + x1 + "     |     " + x2 + "    |     " + x3 + "    |  " );
		}
		System.out.println(" ");			
		}
		

	
	
	
}
