import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Informe o LEVEL do paladino :");
		int Lvl = Integer.parseInt(in.nextLine());
		System.out.println("Informe a skill DISTANCE :");
		int Skill = Integer.parseInt(in.nextLine());
		int SSkill = (int) (Skill*1.10);
		System.out.println("Informe o ATK da munição incluindo FLAWLESS :");
		int Atk = Integer.parseInt(in.nextLine());
		System.out.println("Informe a quantidade de DEX (destreza):");
		int Dex = Integer.parseInt(in.nextLine());
		int MaxDex = (int) (Dex*1.2);
		int MinDex = (int) (Dex*0.8);
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
		System.out.println(" -- HITS  -- ");
		System.out.println("Min : "+MinHit+" -Sharp : "+SminHit);
		System.out.println("Max : "+MaxHit+" -Sharp : "+SMaxHit);
		System.out.println("Med : "+MedHit+" -Sharp : "+SMedHit);
		System.out.println(" -- DPS -- ");
		System.out.println("Sharp : "+SDps);
		System.out.println("Fast  : "+FhandHit);
		System.out.println("Total : "+FDps);
		//Spell
		double Mmult = 1.8; //1.8 - (2.2 holy rose)
		double LSpell = (Lvl*1.3);
		//level
		double Mspell = (Math.pow(Mgl,(1.4))*Mmult);
		//magic level
		double Dspell = (Dex*0.75);
		//dexterity
		double HLspell = (Math.pow(Mgl,(1.4))*2.2);
		//holy rose
		int Hspell =(int) (HLspell+LSpell+Dspell);
		int Spell = (int) (LSpell);
		Spell += (int) Mspell+Dspell;
		
		//System.out.println(" Level "+LSpell);
		//System.out.println(" Magic "+Mspell);
		//System.out.println(" Dex "+Dspell);
		
		System.out.println(" -- SPELLPOWER -- ");
		System.out.println("Padrão : "+Spell+" -Holy : "+Hspell);
		//Burst
		int Minburst = (int) (Spell*0.15);
		int Maxburst = (int) (Spell*0.35);
		int Medburst = CalcMed(Minburst, Maxburst);
		int HMinburst = (int) (Hspell*0.15);
		int HMaxburst = (int) (Hspell*0.35);
		int HMedburst = CalcMed(HMinburst, HMaxburst);
		System.out.println(" -- BURST ARROW -- ");
		System.out.println("Min : "+Minburst+" -Holy : "+HMinburst);
		System.out.println("Max : "+Maxburst+" -Holy : "+HMaxburst);
		System.out.println("Med : "+Medburst+" -Holy : "+HMedburst);
		// SD
		int SdMax = (int) (Spell*1.7);
		int SdMin = (int) (Spell*1.3);
		int SdMed = CalcMed(SdMin, SdMax);
		int HSdmax = (int) (Hspell*1.7);
		int HSdmin = (int) (Hspell*1.3);
		int HSdmed = CalcMed(HSdmin, HSdmax);
		System.out.println(" -- SD -- ");
		System.out.println("Min : "+SdMin+" -Holy : "+HSdmin);
		System.out.println("Max : "+SdMax+" -Holy : "+HSdmax);
		System.out.println("Med : "+SdMed+" -Holy : "+HSdmed);
		//HMM
		int HmmMax = (int) (Spell*0.4);
		int HmmMin = (int) (Spell*0.2);
		int HmmMed = CalcMed(HmmMin, HmmMax);
		int HHmmMax = (int) (Hspell*0.4);
		int HHmmMin = (int) (Hspell*0.2);
		int HHmmMed = CalcMed(HHmmMin, HHmmMax);
		System.out.println(" -- HMM -- ");
		System.out.println("Min : "+HmmMin+" -Holy : "+HHmmMin);
		System.out.println("Max : "+HmmMax+" -Holy : "+HHmmMax);
		System.out.println("Med : "+HmmMed+" -Holy : "+HHmmMed);
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
