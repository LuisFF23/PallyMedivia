import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Informe o LEVEL do paladino :");
		int Lvl = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a skill DISTANCE do paladino :");
		int Skill = Integer.parseInt(in.nextLine());
		int SSkill = (int) (Skill*1.10);
		
		System.out.println("Informe o ATK da munição incluindo FLAWLESS :");
		int Atk = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a quantidade de DEX (destreza):");
		int Dex = Integer.parseInt(in.nextLine());
		int MaxDex = (int) (Dex*1.2);
		int MinDex = (int) (Dex*0.8);
		int DpsDex = Dex/2;
		
		System.out.println("Informe o Magic Level (ML) :");
		int Mgl = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a porcentagem de Sharpshooter :");
		int Psharp = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a porcentagem de Fast hands :");
		int PFhand = Integer.parseInt(in.nextLine());
		in.close(); //close input
		
			int MaxHit = CalcMax(Skill, Atk);
			int MinHit = CalcMin(MaxHit, Lvl);
			int MedHit = CalcMed(MinHit, MaxHit)+Dex;
			MaxHit+= MaxDex;
			MinHit+= MinDex;
			
			int SMaxHit = CalcMax(SSkill, Atk);
			int SminHit = CalcMin(SMaxHit, Lvl);
			int SMedHit = CalcMed(SminHit, SMaxHit)+Dex;
			SMaxHit+= MaxDex;
			SminHit+= MinDex;
			
			int SDps = CalcSharp(MedHit, SMedHit, Psharp);
			int FhandHit = CalcFHand(MedHit, PFhand);
			int FDps = CalcFHand(SDps, PFhand);
			
			
		System.out.println("HITS :  ");
		System.out.println("Maximo = "+SMaxHit);
		System.out.println("Médio = "+MedHit);
		System.out.println("Médio Sharp = "+SMedHit);
		System.out.println("Minimo = "+MinHit);
		System.out.println("DPS ");
		System.out.println("Sharpshooter : "+SDps);
		System.out.println("Fast Hands : "+FhandHit);
		System.out.println("Total : "+FDps);
		
		//Spell
		double Mmult = 1.8; //1.8 - (2.2 holy rose)
		int LSpell = (int) (Lvl*1.3);
		int Spell = (int)LSpell;
		//level
		int Mspell = (int) (Math.pow(Mgl,(1.4))*Mmult);
		//magic level
		Spell += Mspell;
		int Hspell = (int) (Math.pow(Mgl,(1.4))*2.2);
		//holy rose
		int Dspell = (int) (Dex*0.75);
		//dexterity
		Spell += Dspell;
		System.out.println("SPELLPOWER : ");
		System.out.println("Padrão : "+Spell);
		System.out.println("Holy rose : "+(LSpell+Dspell+Hspell));
		
		//Burst
		int Burst = (int) (Lvl/3 + Math.pow(Mgl, 1.33333333));
		int Minburst = (int) (Burst*0.3);
		int Maxburst = (int) (Burst*0.7);
		int Medburst = Minburst + (Maxburst-Minburst)/2;
		System.out.println("BURST ARROW : ");
		System.out.println("Minimo : "+Minburst);
		System.out.println("Médio : "+Medburst);
		System.out.println("Máximo : "+Maxburst);
		// formulas magic spell power e DPS
	}
	
	public static int CalcMax(int Skill, int Atk) {
				
		double SkillPow = Math.pow(Skill, 2);
		int MaxHit = (int) (20 + (SkillPow/1600)*Atk);
		return MaxHit;
	}
	
	public static int CalcMin(int MaxHit, int Lvl) {
		
		int MinHit = (int) (Lvl/5 + (MaxHit*0.2));
		return MinHit;
	}
	
	public static int CalcMed(int MinHit, int MaxHit) {
		
		int MedHit = MaxHit - (MaxHit-MinHit)/2;		
		return MedHit;
	}
	
	public static int CalcFHand (int MedHit, int PFhand) {
		
		int normal = MedHit * 100;
		int fast = MedHit * PFhand;
		int FH = (normal+fast) /100;
		return FH;
	}
	
	public static int CalcSharp(int MedHit,int SMedHit, int PSharp) {
		
		PSharp=PSharp*3;
		int normal = MedHit * (100-PSharp);
		int sharp = SMedHit * PSharp;
		int SS = (normal + sharp) / 100;
		return SS;
	}

}
