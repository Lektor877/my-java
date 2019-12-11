//ДЗ Max Pomiskiy

package Course;

import Competitor.Cat;
import Competitor.Dog;
import Competitor.Human;
import Competitor.Team;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course(new Cross(300), new Water(5), new Cross(800), new Wall(2));
        Team team1 = new Team("Team 1", new Human("Max"), new Cat("Liza"), new Dog("Veta"), new Dog("Nysa"));
        Team team2 = new Team("Team 2", new Human("Molly"), new Cat("Frank"), new Dog("Tom"), new Dog("Chip"));

        course1.doit(team1);
        course1.doit(team2);
        System.out.println("\n===== RESULTS =====\n");
        team1.showResults();
        System.out.println();
        team2.showResults();
    }
}
