import java.util.Scanner;

public class main {

	public static void main(final String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Informe o LEVEL do paladino :");
		int Lvl = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a skill DISTANCE do paladino :");
		int Skill = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe o ATK da munição incluindo FLAWLESS :");
		int Atk = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe a quantidade de DEX (destreza):");
		int Dex = Integer.parseInt(in.nextLine());
		
		System.out.println("Informe o Magic Level (ML) :");
		int Mgl = Integer.parseInt(in.nextLine());
		
		double SkillPow = Math.pow(Skill, 2);
		double MaxHit = 20 + (SkillPow/1600)*Atk;
		double MinHit = Lvl/5 + (MaxHit*0.2);
		double MedHit = MinHit + (MaxHit-MinHit)/2;
		
		double MaxDex = Dex*1.2;
		double MinDex = Dex*0.8;
		
		System.out.println("Maximo = "+(MaxHit+MaxDex));
		System.out.println("Médio = "+(MedHit+Dex));
		System.out.println("Minimo = "+(MinHit+MinDex));
		
		double DpsHit = ((MedHit+Dex)*30)/60;
		
		System.out.println("DPS físico :"+DpsHit);
		
		//spell
		
		double Mmult = 1.8; //1.8 - (2.2 holy rose)
		
		double Spell = 0;
		Spell = Lvl*1.3;
		System.out.println("Spellpower LVL :"+Spell);
		
		double Mspell = Math.pow(Mgl,(1.4))*Mmult;
		System.out.println("Spellpower ML :"+Mspell);
		Spell += Mspell;
		
		double Dspell = Dex*0.75;
		System.out.println("Spellpower DEX :"+Dspell);
		Spell += Dspell;
		
		System.out.println("Spellpower :"+Spell);
		
		// formulas magic spell power e DPS
		
		in.close();
	}

}
