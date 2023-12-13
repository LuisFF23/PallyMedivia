import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Paladino P = new Paladino();
		//Input informations
		InputDat(P);
		
		//Hits
		CalcHits(P);
		
		//Spell		
		int Spell = CalcSpell(P);
		int Hspell = CalcHspell(P);
		
		//Burst
		BurstDamages(Spell, Hspell);
		
		//HMM
		HmmDamages(Spell, Hspell);
		
		//Explosion
		ExpDamages(Spell, Hspell);
		
		// SD
		SdDamages(Spell, Hspell);
	}
	
	public static void CalcHits (Paladino P) {
		
		int Lvl = P.GetLevel();
		int Skill = P.GetSkill();
		int Dex = P.GetDextr();
		int Atk = P.GetAtack();
		
		int MaxDex = (int) (Dex*1.2);
		int MinDex = (int) (Dex*0.8);
		int SSkill = (int) (Skill*1.10);
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
		int Psharp = P.GetSharp();
		int PFhand = P.GetFasth();
		int SharpDps = CalcSharp(MedHit, SMedHit, Psharp);
		int FhandHit = CalcFHand(MedHit, PFhand);
		int FastDps = CalcFHand(SharpDps, PFhand);
		
		System.out.println(" -- HITS  -- ");
		System.out.println("Min : "+MinHit+" -Sharp : "+SminHit);
		System.out.println("Max : "+MaxHit+" -Sharp : "+SMaxHit);
		System.out.println("Med : "+MedHit+" -Sharp : "+SMedHit);
		System.out.println(" -- DPS -- ");
		System.out.println("Sharp : "+SharpDps);
		System.out.println("Fast  : "+FhandHit);
		System.out.println("Total : "+FastDps);
		
	}
	public static int CalcSpell (Paladino P) {
		
		int Lvl = P.GetLevel();
		int Mgl = P.GetMagic();
		int Dex = P.GetDextr();
		System.out.println(" -- SPELLPOWER -- ");
		//level
		double LSpell = (Lvl*1.3);
		//magic level
		double Mspell = (Math.pow(Mgl,(1.4))*1.8);
		//dexterity
		double Dspell = (Dex*0.75);
		
		int Spell = (int) (LSpell+ Mspell+Dspell);
		System.out.print("Padrão : "+Spell);
		return Spell;
	}
	public static int CalcHspell (Paladino P) {
		
		int Lvl = P.GetLevel();
		int Mgl = P.GetMagic();
		int Dex = P.GetDextr();
		//level
		double LSpell = (Lvl*1.3);
		//magic level
		double Mspell = (Math.pow(Mgl,(1.4))*2.2);
		//dexterity
		double Dspell = (Dex*0.75);
		
		int Hspell =(int) (Mspell+LSpell+Dspell);
		System.out.println(" -Holy : "+Hspell);
		return Hspell;
	}
	public static void BurstDamages (int Spell, int Hspell) {
		
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
		
	}
	public static void HmmDamages (int Spell, int Hspell) {
		
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
	
	public static void ExpDamages (int Spell, int Hspell) {
		
		int ExpMax = (int) (Spell*0.7);
		int ExpMin = (int) (Spell*0.3);
		int ExpMed = CalcMed(ExpMin, ExpMax);
		int HExpMax = (int) (Hspell*0.7);
		int HExpMin = (int) (Hspell*0.3);
		int HExpMed = CalcMed(HExpMin, HExpMax);
		System.out.println(" -- EXPLOSION -- ");
		System.out.println("Min : "+ExpMin+" -Holy : "+HExpMin);
		System.out.println("Max : "+ExpMax+" -Holy : "+HExpMax);
		System.out.println("Med : "+ExpMed+" -Holy : "+HExpMed);
		
	}
	
	public static void SdDamages (int Spell, int Hspell) {
		
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
		
	}
	
	public static void InputDat(Paladino P) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Informe o LEVEL do paladino :");
		P.SetLevel(Integer.parseInt(in.nextLine()));
		System.out.println("Informe a skill DISTANCE :");
		P.SetSkill(Integer.parseInt(in.nextLine()));
		System.out.println("Informe o ATK da munição incluindo FLAWLESS :");
		P.SetAtack(Integer.parseInt(in.nextLine()));
		System.out.println("Informe a quantidade de DEX (destreza):");
		P.SetDextr(Integer.parseInt(in.nextLine()));
		System.out.println("Informe o Magic Level (ML) :");
		P.SetMagic(Integer.parseInt(in.nextLine()));
		System.out.println("Informe a porcentagem de Sharpshooter :");
		P.SetSharp(Integer.parseInt(in.nextLine()));
		System.out.println("Informe a porcentagem de Fast hands :");
		P.SetFasth(Integer.parseInt(in.nextLine()));
		in.close(); //close input
		
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
