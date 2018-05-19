package presentationlayer;


import functionlayer.LoginSampleException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command extends HttpServlet{

    private static HashMap<String, Command> commands;

    private static void initCommands() throws ServletException, IOException {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "help", new Help() );
        commands.put( "order", new Order());
        commands.put( "loginpage", new LoginPage());
        commands.put( "registration", new Registration());
        commands.put( "customorder", new CustomOrder());
        commands.put( "myorders", new MyOrders());
        commands.put( "userInfo", new UserInfo());
        commands.put( "updateinfopage", new UpdateInfoPage());
        commands.put( "customerpage", new CustomerPage());
        commands.put( "logout", new Logout());
        commands.put( "inventory", new Inventory());
        commands.put( "allcurrentorders", new CurrentOrders());
        commands.put( "allorders", new AllOrders());
        commands.put( "specificOrder", new SpecificOrder());
        commands.put( "specificuser", new SpecificUser());
        commands.put( "updateinventory", new UpdateInventory());
        commands.put( "updateinventorypage", new UpdateInventoryPage());
        commands.put( "updateInfo", new UpdateUserInfo());
        commands.put( "userlist", new UserList());
        commands.put( "customerpage", new CustomerPage());
        commands.put( "updateinfo", new UpdateUserInfo());
        commands.put( "sendorder", new SendOrder());
        commands.put( "adminpage", new AdminPage());
        commands.put( "showItemlist", new ShowItemlist());
        commands.put( "addtoinventory", new AddToInventory());

        commands.put( "userprofile", new UserProfile());


    }

    static Command from( HttpServletRequest request ) throws ServletException, IOException {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, ClassNotFoundException, ServletException;;

}