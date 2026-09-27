package builder;


//http://www.hubberspot.com/2013/06/how-to-implement-builder-design-pattern.html
// 1. Create a Robot class which is to be build by 
// Builder Design Pattern.
public class Robot {

	// 2. Robot has few properties/characteristics

	private String robotHead;
	private String robotTorso;
	private String robotArms;
	private String robotLegs;

	// 3. Create getters for each characteristics
	public String getRobotHead() {
		return robotHead;
	}

	public String getRobotTorso() {
		return robotTorso;
	}

	public String getRobotArms() {
		return robotArms;
	}

	public String getRobotLegs() {
		return robotLegs;
	}

	// 4. Create a static class which will build our
	// Robot
	public static class RobotBuilder {
		// 5. Provide it with properties with which it will
		// prepare the required Robot
		private String robotHead = "";
		private String robotTorso = "";
		private String robotArms = "";
		private String robotLegs = "";

		public RobotBuilder() {

		}


		// 6. Create methods for each properties which Robot
		// requires to get in action. The client will pass
		// necessary values for the type of Robot they want.
		
		
		public RobotBuilder buildRobotHead(String robotHead) {
			this.robotHead =robotHead;
			return this;
		}
		
		public RobotBuilder buildRobotTorso(String robotTorso) {
			this.robotTorso =robotTorso;
			return this;
		}
		
		public RobotBuilder buildRobotArms(String robotArms) {
			this.robotArms =robotArms;
			return this;
		}
		
		public RobotBuilder buildRobotLegs(String robotLegs) {
			this.robotLegs =robotLegs;
			return this;
		}
		
		

		// 7. Final build method will return us back the required
		// Robot
		public Robot build() {
			return new Robot(this);
		} 
	}

	
	
	// 8. Actual preparation of Robot by RobotBuilder
	private Robot(RobotBuilder robotBuilder) {
		robotHead = robotBuilder.robotHead;
		robotTorso = robotBuilder.robotTorso;
		robotArms = robotBuilder.robotArms;
		robotLegs = robotBuilder.robotLegs;
	}

	// 9. Creation of Iron Robot and Steel Robot by the
	// client.
	public static void main(String[] args) {
	
		System.out.println("Let's build a Iron Robot .... \n");
	
		Robot ironRobot = new Robot.RobotBuilder()
				.buildRobotHead("Iron Head")
				.buildRobotTorso("Iron Torso")
				.buildRobotArms("Iron Arms")
				.buildRobotLegs("Iron Legs")
				.build();
		
		System.out.println("Iron Robot is build with following specs : \n");
		
		System.out.println("Robot Head : " + ironRobot.getRobotHead());
		System.out.println("Robot Torso : " + ironRobot.getRobotTorso());
		System.out.println("Robot Arms : " + ironRobot.getRobotArms());
		System.out.println("Robot Legs : " + ironRobot.getRobotLegs());
		System.out.println();
		System.out.println("Let's build a Steel Robot .... \n");
		
		Robot steelRobot = new Robot.RobotBuilder()
				.buildRobotHead("Steel Head")
				.buildRobotTorso("Steel Torso")
				.buildRobotArms("Steel Arms")
				.buildRobotLegs("Steel Legs")
				.build();
	
		
		System.out.println("Steel Robot is build with following specs : \n");
		System.out.println("Robot Head : " + steelRobot.getRobotHead());
		System.out.println("Robot Torso : " + steelRobot.getRobotTorso());
		System.out.println("Robot Arms : " + steelRobot.getRobotArms());
		System.out.println("Robot Legs : " + steelRobot.getRobotLegs());
		    
	}
}