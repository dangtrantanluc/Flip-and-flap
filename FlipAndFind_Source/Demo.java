import controller.GameController;
import controller.IController;
import model.IUser;
import model.SystemGame;
import model.User;

public class Demo {
    public static void main(String[] args) {
        SystemGame systemGame= new SystemGame();
        IController gameController= new GameController(systemGame);
        IUser user1 = new User("player1",2,600,1000);
        IUser user2 = new User("player2",1,300,300);
        IUser user3 = new User("player3",3,1200,1300);
        IUser user4 = new User("player4",2,400,600);
        IUser user5 = new User("player5",4,1500,2000);
        IUser user6 = new User("player6",1,200,200);
        IUser user7 = new User("player7",1,200,200);
        IUser user8 = new User("player8",1,200,200);
        IUser user9 = new User("player9",1,200,200);
        IUser user10 = new User("player10",1,200,200);
        systemGame.addUser(user1);
        systemGame.addUser(user2);
        systemGame.addUser(user3);
        systemGame.addUser(user4);
        systemGame.addUser(user5);
        systemGame.addUser(user6);
        systemGame.addUser(user7);
        systemGame.addUser(user8);
        systemGame.addUser(user9);
        systemGame.addUser(user10);
    }
}
