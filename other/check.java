abstract class human {
	abstract void displaySex();
}

class man extends human {
	public void displaySex() {
		System.out.println("M");
	}
}

class woman extends human {
	public void displaySex() {
		System.out.println("F");
	}
}

interface humanSex {
	public abstract void displaySex();
}

class manI implements humanSex {
	public void displaySex() {
		System.out.println("M");
	}
}

class womanI implements humanSex {
	public void displaySex() {
		System.out.println("F");
	}
}


public class check {
	public static void main(String[] args) {
		human human1 = new man();
		human1.displaySex();
		human human2 = new woman();
		human2.displaySex();

		humanSex human3 = new manI();
		human3.displaySex();
		humanSex human4 = new womanI();
		human4.displaySex();
	}
}
