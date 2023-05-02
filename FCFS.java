import java.util.*;
import java.io.*;
public class FCFS{
	public static void main(String[] args)throws Exception{
		int n,x,pid[],at[],bt[],ct[],tat[],wt[];
		float atat=0,awt=0;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of process:");
		n=s.nextInt();
		pid=new int[n]; at=new int[n];
		bt=new int[n]; ct=new int[n];
		tat=new int[n]; wt=new int[n];
		for(int i=0;i<n;i++){
			pid[i]=i+1;
			System.out.print("Enter the AT for process "+pid[i]+":");
			at[i]=s.nextInt();
			System.out.print("Enter the BT for process "+pid[i]+":");
			bt[i]=s.nextInt();
		}
		System.out.println("\n----------------------------------------------------");
		System.out.println("Process		AT		BT");
		for(int i=0;i<n;i++)
			System.out.println(pid[i]+"		"+at[i]+"		"+bt[i]);
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(at[i]>at[j]){
					int temp=at[i];
					at[i]=at[j];
					at[j]=temp;
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					temp=pid[i];
					pid[i]=pid[j];
					pid[j]=temp;
				}
			}
		}
		System.out.println("\nAfter sorting using arrival time");
		System.out.println("----------------------------------------------------");
		System.out.println("Process		AT		BT");
		for(int i=0;i<n;i++)
			System.out.println(pid[i]+"		"+at[i]+"		"+bt[i]);
		ct[0]=bt[0];
		for(int i=1;i<n;i++){
			if(ct[i-1]>=at[i])
				ct[i]=ct[i-1]+bt[i];
			else
				ct[i]=at[i]+bt[i];
		}
		for(int i=0;i<n;i++){
			tat[i]=ct[i]-at[i];
			wt[i]=tat[i]-bt[i];
			atat=atat+tat[i];
			awt=awt+wt[i];
		}
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Process		AT		BT		wT		tat");
		for(int i=0;i<n;i++)
			System.out.println(pid[i]+"		"+at[i]+"		"+bt[i]+"		"+wt[i]+"		"+tat[i]);
		System.out.println("Average Waiting time: "+awt/n);
		System.out.println("Average turn around time: "+atat/n);
	}
}