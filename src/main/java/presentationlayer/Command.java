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
        commands.put("logout", new Logout());
        commands.put("inventory", new Inventory());
        commands.put("allCurrentOrders", new CurrentOrders());
        commands.put("allOrders", new AllOrders());
        commands.put("specificOrder", new SpecificOrder());
        commands.put("updateInventory", new UpdateInventory());
        commands.put("updateInfo", new UpdateUserInfo());
        commands.put("userList", new UserList());
        commands.put( "updateinfopage", new UpdateInfoPage());
        commands.put( "customerpage", new CustomerPage());
        commands.put( "updateinfo", new UpdateUserInfo());

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