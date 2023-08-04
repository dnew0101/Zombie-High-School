import java.util.Scanner;

public class ZombieHigh {
	public static void main(String[] args) {
		int difficulty;
		int choice;
		int roll;
		boolean alive = true;
		String name;
		ZombieCharacter zombie = null;
		ZombieCharacter fastZombie = null;
		ZombieCharacter strongZombie = null;
		ZombieCharacter smartZombie = null;
		ZombieCharacter bossZombie = null;
		Characters student = null;// character is name of our object class
		Scanner s = new Scanner(System.in);

		System.out.println("Escape: Zombie High \nPress Enter to play");// title screen
		s.nextLine();// user inputs enter to advance
		
		difficulty = promptNumberReadLine(s,
				"Choose your difficulty: \n1)Easy \n2)Medium \n3)Hard", //Difficulty will be selected and will be injected into the ZombieCharacter class
				3);
		if (difficulty == 1) {
			zombie = new ZombieCharacter(1, 1, 1, 1, "Regular Zombie", false);
			bossZombie = new ZombieCharacter(3, 1, 3, 3, "Boss Zombie", true);
		} 												// zombie stats in order: int power, int difficulty, int speed, int smarts, string name, boolean isBoss
		if (difficulty == 2) {
			zombie = new ZombieCharacter(1, 2, 1, 1, "Regular Zombie", false); 
			bossZombie = new ZombieCharacter(3, 2, 3, 3, "Boss Zombie", true);
		}
		if (difficulty == 3) {
			zombie = new ZombieCharacter(1, 3, 1, 1, "Regular Zombie", false);
			bossZombie = new ZombieCharacter(3, 3, 3, 3, "Boss Zombie", true);
		}

		choice = promptNumberReadLine(s,
				"Choose your character: \n1)The Athlete \n2)The Class President \n3)The Cheerleader \n4)The Brainiac \n5)The Bully",
				5);
		// method: int promptNumberReadLine(Scanner s, String prompt, int max)
		if (choice == 1) {
			student = new Characters("Athlete", 10, 8, 2);// character(String name, int power, int speed, int smarts)
		}
		if (choice == 2) {
			student = new Characters("Class President", 6, 6, 8);// character(String name, int power, int speed, int
																	// smarts)
		}
		if (choice == 3) {
			student = new Characters("Cheerleader", 5, 9, 6);// character(String name, int power, int speed, int smarts)
		}
		if (choice == 4) {
			student = new Characters("Brainiac", 1, 9, 10);// character(String name, int power, int speed, int smarts)
		}
		if (choice == 5) {
			student = new Characters("Bully", 5, 10, 5);// character(String name, int power, int speed, int smarts)
		}

		s.nextLine();// user inputs enter to advance
		System.out.println("You are the " + student.getName());
		System.out.println(student.toString());// this will call the override toString method in object class
		// this should look like:
		// You are the Athlete
		// Power: 10
		// Speed: 8
		// Smarts: 2

		int power = student.getPower();// these values are used for diceRoll
		int speed = student.getSpeed();
		int smarts = student.getSmarts();
		s.nextLine();// user inputs enter to advance

		System.out.println(
				"It's lunch time. You are in the cafeteria when you hear the principal on the school's announcement system.");
		s.nextLine();// user inputs enter to advance

		System.out.println(
				"*ALARM* \n'Attention, students.. The high school has been infested with zombies. Run while you still AaaaAahhHHHh!!!' \n*BEEEEP*");
		s.nextLine();// user inputs enter to advance

		System.out.println("A student near the cafeteria doors screams, 'ZOMBIES!! THEY'RE HERE!'");
		s.nextLine();// user inputs enter to advance

		choice = promptNumberReadLine(s, "What will you do? \n1)Find a place to hide \n2)Escape through the back", 2);// method
																														// will
																														// return
																														// 1
																														// or
																														// 2
		if (choice == 1) {// hide
			s.nextLine();// user inputs enter to advance
			System.out.println("You choose to hide. \nYou must roll at least " + zombie.getSmarts() + " for success. \nPress Enter to roll.");
			s.nextLine();// user inputs enter to advance
			student.diceRoll(smarts);// calls out diceRoll(int stat) method located in object class
			System.out.println("You rolled a " + student.getDiceRoll());
			s.nextLine();// user inputs enter to advance
			if (student.getDiceRoll() >= zombie.getSmarts()) {
				System.out.println(
						"You sneak into the kitchen and hide inside a trash bin. An hour passes by and you fall asleep.");
				s.nextLine();// user inputs enter to advance
				choice = promptNumberReadLine(s, "What will you do? \n1)Wake up! \n2)Stay asleep", 2);
				if (choice == 1) {// wake up
					System.out.println("You wake up feeling refreshed. +10 Power!");
					power = power + 10;
					student.setPower(power);
					s.nextLine();// user inputs enter to advance
					System.out.println(student.toString());// displays updated stats
					s.nextLine();// user inputs enter to advance
					// go to boss fight
				}
				if (choice == 2) {// sleep
					s.nextLine();// user inputs enter to advance
					System.out.println("Another hour passes by. You begin to snore obnoxiously loud.");
					s.nextLine();// user inputs enter to advance
					System.out.println(
							"A horde of zombies find where you are hiding and feasts on your brains! You died.");
					alive = false;
					System.exit(0);// GAME OVER
				}
			} else {
				System.out.println(
						"You weren't sneaky enough. A horde of zombies spotted you and are headed your way. You try to escape through the back.");
				choice = 2;// hiding fails, you resort to choice 2 (escape)
				s.nextLine();// user inputs enter to advance
			}
		}
		if (choice == 2) {// escape
			choice = promptNumberReadLine(s,
					"You escape through the back and see an empty hallway. \nWhat will you do? \n1)Walk \n2)Run", 2);
			while (true) {// outer loop
				if (choice == 1) {// walk
					s.nextLine();// user inputs enter to advance
					System.out.println(
							"You are too slow. You make it halfway down the hallway when a zombie jumps at you from around the corner.");
					s.nextLine();// user inputs enter to advance
					System.out.println("The zombie feasts on your brains! You died.");
					alive = false;
					break;// GAME OVER
				}
				if (choice == 2) {// run
					s.nextLine();// user inputs enter to advance
					System.out.println(
							"You choose to run. \nYou must roll at least " + zombie.getSpeed() + " for success. \nPress Enter to roll.");
					s.nextLine();// user inputs enter to advance
					roll = student.diceRoll(speed);// calls out diceRoll(int stat) method located in object class
					System.out.println("You rolled a " + student.getDiceRoll());
					s.nextLine();// user inputs enter to advance
					System.out.println("You make a run for it down the hallway.");
					if (roll >= zombie.getSpeed()) {
						choice = promptNumberReadLine(s,
								"You make it halfway down the hallway when you attract the attention of a zombie. It chases after you. "
										+ "\nWhat will you do? \n1)Turn around and fight \n2)Find a place to hide",
								2);
						while (true) {// inner loop
							if (choice == 1) {// fight
								s.nextLine();// user inputs enter to advance
								System.out.println("Prepare to fight! \nYou must roll at least " + zombie.getPower() + " for success. \nPress Enter to roll.");
								s.nextLine();// user inputs enter to advance
								roll = student.diceRoll(power);
								System.out.println("You rolled a " + student.getDiceRoll());
								s.nextLine();// user inputs enter to advance
								if (roll >= zombie.getPower()) {
									System.out.println(
											"You defeat the zombie. \nYou get an inrush of adrenaline. +10 Power!");
									power = power + 10;
									student.setPower(power);
									System.out.println(student.toString());// displays updated stats
									s.nextLine();// user inputs enter to advance
									break;// go to boss fight
								} else {
									System.out.println(
											"Your attack missed. The zombie lunges at you and feasts on your brains! You died.");
									alive = false;
									break;// GAME OVER
								}
							}
							if (choice == 2) {// hide
								System.out.println(
										"You choose to hide. \nYou must roll at least " + zombie.getSmarts() + " for success. \nPress Enter to roll.");
								s.nextLine();// user inputs enter to advance
								roll = student.diceRoll(smarts);
								s.nextLine();// user inputs enter to advance
								System.out.println("You rolled a " + student.getDiceRoll());
								s.nextLine();// user inputs enter to advance
								if (roll >= zombie.getSmarts()) {
									System.out.println(
											"You run and hide inside a classroom. You quickly slam the door shut.");
									s.nextLine();// user inputs enter to advance
									choice = promptNumberReadLine(s,
											"You don't have much time. \nWhat will you do? \n1)Barricade the door \n2)Look around",
											2);
									if (choice == 1) {// barricade
										System.out.println(
												"You moved a bookshelf in front of the door. \nAll this work has gotten you riled up. +2 Power!");
										power = power + 2;
										student.setPower(power);
										s.nextLine();// user inputs enter to advance
										System.out.println(student.toString());// displays updated stats
										s.nextLine();// user inputs enter to advance
										System.out.println(
												"*CRASH* A zombie broke through the classroom window from outside. A zombie approaches.");
									}
									if (choice == 2) {// look around
										System.out.println(
												"You notice leftover resources from the science fair are left out. You see a car battery and some scrap metal.");
										s.nextLine();// user inputs enter to advance
										choice = promptNumberReadLine(s,
												"Do you know what to do with it? \n1)Yes \n2)No", 2);
										if (choice == 1) {// yes
											name = student.getName();
											if (name == "Brainiac") {// only brainiac knows
												System.out.println(
														"You use the materials to craft a taser! *ZzzAPP* +15 Power!!");
												power = power + 15;
												student.setPower(power);
												System.out.println(student.toString());// displays updated stats
											} else {
												s.nextLine();// user inputs enter to advance
												System.out.println(
														"You have no idea what to do with these materials. All you got was a headache thinking about it.");
												s.nextLine();// user inputs enter to advance
												System.out.println(
														"You pick up a metal rod to use as a blunt object. +2 Power");
												power = power + 2;
												student.setPower(power);
												System.out.println(student.toString());// displays updated stats
											}
											s.nextLine();// user inputs enter to advance
											System.out.println(
													"You didn't barricade the door. A zombie busts through and attacks.");
										}
										if (choice == 2) {// no
											s.nextLine();// user inputs enter to advance
											System.out.println(
													"At least you're honest with yourself. You pick up a metal rod to use as a blunt object. +5 Power!");
											power = power + 5;
											student.setPower(power);
											System.out.println(student.toString());// displays updated stats
											s.nextLine();// user inputs enter to advance
											System.out.println(
													"You didn't barricade the door. A zombie busts through and attacks.");
											choice = 1;
										}
									}
								} else {
									System.out.println(
											"You cannot find a hiding spot in time. The zombie approaches you.");
									choice = 1;
								}
							}
						} // end of inner loop
						break;
					} else {
						choice = 1;// running fails, return to choice 1 (walk)
					}
				}
			} // end of outer loop
		}
		if (alive) {// boss fight
			System.out.println("You see the school entrance is clear of zombies. You run towards it.");
			s.nextLine();// user inputs enter to advance
			choice = promptNumberReadLine(s, "A zombie boss suddenly appears. \nWhat will you do? \n1)Run \n2)Fight",
					2);
			if (choice == 1) {
				System.out.println("Can't escape. You must fight!");
				choice = 2;
				s.nextLine();// user inputs enter to advance
			}
			if (choice == 2) {
				s.nextLine();// user inputs enter to advance
				System.out.println(
						"Prepare to fight! \nYou must roll greater than " + bossZombie.getPower() + " for success. \nPress Enter to roll.");
				s.nextLine();// user inputs enter to advance
				roll = student.diceRoll(power);
				System.out.println("You rolled a " + student.getDiceRoll());
				s.nextLine();// user inputs enter to advance
				if (roll > bossZombie.getPower()) {
					System.out.println("You defeated the zombie boss. You made it out alive!");
					// YOU WIN
				} else {
					System.out.println(
							"You're attack barely leaves a scratch. The zombie boss grabs you by the waist and devours you whole! You died.");
					// GAME OVER
				}
			}
		}
	}

	public static int promptNumberReadLine(Scanner s, String prompt, int max) {
		// print prompt and if user enter is valid, return number. if not, print error
		// message and repeat the process.
		while (true) {
			System.out.println(prompt);
			if (s.hasNextInt()) {
				int number = s.nextInt();
				if (number >= 1 && number <= max) {
					return number;
				} else {
					//s.nextLine();// ***NEW*** This was casuing the user to hit enter again to see prompt IF value was incorrect.
					System.out.println("That was not a valid number! Please try again.");
					s.nextLine();// user inputs enter to advance
				}
			} else {
				//s.nextLine();// ***NEW*** This was casuing the user to hit enter again to see prompt IF value was incorrect.
				System.out.println("That was not a valid number! Please try again.");
				s.nextLine();// user inputs enter to advance
			}
		}
	}
}


