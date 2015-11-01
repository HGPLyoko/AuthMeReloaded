package fr.xephi.authme.command;

import fr.xephi.authme.command.executable.*;
import fr.xephi.authme.command.executable.authme.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnusedDeclaration")
public class CommandManager {

    /** The list of commandDescriptions. */
    private List<CommandDescription> commandDescriptions = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param registerCommands True to register the commands, false otherwise.
     */
    public CommandManager(boolean registerCommands) {
        // Register the commands
        if(registerCommands)
            registerCommands();
    }

    /**
     * Register all commands.
     */
    @SuppressWarnings("SpellCheckingInspection")
    public void registerCommands() {
        // Register the base Dungeon Maze command
        CommandDescription authMeCommand = new CommandDescription(
                new AuthMeCommand(),
                new ArrayList<String>() {{
                    add("authme");
                }},
                "Main command",
                "The main AuthMeReloaded command. The root for all the other commands.", null);

        // Register the help command
        CommandDescription helpCommand = new CommandDescription(
                new HelpCommand(),
                new ArrayList<String>() {{
                    add("help");
                    add("hlp");
                    add("h");
                    add("sos");
                    add("?");
                }},
                "View help",
                "View detailed help pages about AuthMeReloaded commands.",
                authMeCommand);
        helpCommand.addArgument(new CommandArgumentDescription("query", "The command or query to view help for.", true));
        helpCommand.setMaximumArguments(false);

        // Register the register command
        CommandDescription registerCommand = new CommandDescription(
                new RegisterCommand(),
                new ArrayList<String>() {{
                    add("register");
                    add("reg");
                }},
                "Register a player",
                "Register the specified player with the specified password.",
                authMeCommand);
        registerCommand.setCommandPermissions("authme.admin.register", CommandPermissions.DefaultPermission.OP_ONLY);
        registerCommand.addArgument(new CommandArgumentDescription("player", "Player name", false));
        registerCommand.addArgument(new CommandArgumentDescription("password", "Password", false));

        // Register the unregister command
        CommandDescription unregisterCommand = new CommandDescription(
                new UnregisterCommand(),
                new ArrayList<String>() {{
                    add("unregister");
                    add("unreg");
                    add("delete");
                    add("del");
                }},
                "Unregister a player",
                "Unregister the specified player.",
                authMeCommand);
        unregisterCommand.setCommandPermissions("authme.admin.unregister", CommandPermissions.DefaultPermission.OP_ONLY);
        unregisterCommand.addArgument(new CommandArgumentDescription("player", "Player name", false));

        // Register the forcelogin command
        CommandDescription forceLoginCommand = new CommandDescription(
                new ForceLoginCommand(),
                new ArrayList<String>() {{
                    add("forcelogin");
                    add("login");
                }},
                "Force login player",
                "Force the specified player to login.",
                authMeCommand);
        forceLoginCommand.setCommandPermissions("authme.admin.forcelogin", CommandPermissions.DefaultPermission.OP_ONLY);
        forceLoginCommand.addArgument(new CommandArgumentDescription("player", "Online player name", true));

        // Register the changepassword command
        CommandDescription changePasswordCommand = new CommandDescription(
                new RegisterCommand(),
                new ArrayList<String>() {{
                    add("changepassword");
                    add("changepass");
                    add("cp");
                }},
                "Change player's password",
                "Change the password of a player.",
                authMeCommand);
        changePasswordCommand.setCommandPermissions("authme.admin.changepassword", CommandPermissions.DefaultPermission.OP_ONLY);
        changePasswordCommand.addArgument(new CommandArgumentDescription("player", "Player name", false));
        changePasswordCommand.addArgument(new CommandArgumentDescription("password", "New password", false));

        // Register the purge command
        CommandDescription lastLoginCommand = new CommandDescription(
                new LastLoginCommand(),
                new ArrayList<String>() {{
                    add("lastlogin");
                    add("ll");
                }},
                "Player's last login",
                "View the date of the specified players last login",
                authMeCommand);
        lastLoginCommand.setCommandPermissions("authme.admin.lastlogin", CommandPermissions.DefaultPermission.OP_ONLY);
        lastLoginCommand.addArgument(new CommandArgumentDescription("player", "Player name", true));

        // Register the accounts command
        CommandDescription accountsCommand = new CommandDescription(
                new AccountsCommand(),
                new ArrayList<String>() {{
                    add("accounts");
                    add("account");
                }},
                "Display player accounts",
                "Display all accounts of a player by it's player name or IP.",
                authMeCommand);
        accountsCommand.setCommandPermissions("authme.admin.accounts", CommandPermissions.DefaultPermission.OP_ONLY);
        accountsCommand.addArgument(new CommandArgumentDescription("player", "Player name or IP", true));

        // Register the getemail command
        CommandDescription getEmailCommand = new CommandDescription(
                new GetEmailCommand(),
                new ArrayList<String>() {{
                    add("getemail");
                    add("getmail");
                    add("email");
                    add("mail");
                }},
                "Display player's email",
                "Display the email address of the specified player if set.",
                authMeCommand);
        getEmailCommand.setCommandPermissions("authme.admin.getemail", CommandPermissions.DefaultPermission.OP_ONLY);
        getEmailCommand.addArgument(new CommandArgumentDescription("player", "Player name", true));

        // Register the setemail command
        CommandDescription setEmailCommand = new CommandDescription(
                new SetEmailCommand(),
                new ArrayList<String>() {{
                    add("chgemail");
                    add("chgmail");
                    add("setemail");
                    add("setmail");
                }},
                "Change player's email",
                "Change the email address of the specified player.",
                authMeCommand);
        setEmailCommand.setCommandPermissions("authme.admin.chgemail", CommandPermissions.DefaultPermission.OP_ONLY);
        setEmailCommand.addArgument(new CommandArgumentDescription("player", "Player name", false));
        setEmailCommand.addArgument(new CommandArgumentDescription("email", "Player email", false));

        // Register the getip command
        CommandDescription getIpCommand = new CommandDescription(
                new GetIpCommand(),
                new ArrayList<String>() {{
                    add("getip");
                    add("ip");
                }},
                "Get player's IP",
                "Get the IP address of the specified online player.",
                authMeCommand);
        getIpCommand.setCommandPermissions("authme.admin.getip", CommandPermissions.DefaultPermission.OP_ONLY);
        getIpCommand.addArgument(new CommandArgumentDescription("player", "Online player name", true));

        // Register the spawn command
        CommandDescription spawnCommand = new CommandDescription(
                new SpawnCommand(),
                new ArrayList<String>() {{
                    add("spawn");
                    add("home");
                }},
                "Teleport to spawn",
                "Teleport to the spawn.",
                authMeCommand);
        spawnCommand.setCommandPermissions("authme.admin.spawn", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the setspawn command
        CommandDescription setSpawnCommand = new CommandDescription(
                new SetSpawnCommand(),
                new ArrayList<String>() {{
                    add("setspawn");
                    add("chgspawn");
                }},
                "Change the spawn",
                "Change the player's spawn to your current position.",
                authMeCommand);
        setSpawnCommand.setCommandPermissions("authme.admin.setspawn", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the firstspawn command
        CommandDescription firstSpawnCommand = new CommandDescription(
                new FirstSpawnCommand(),
                new ArrayList<String>() {{
                    add("firstspawn");
                    add("firsthome");
                }},
                "Teleport to first spawn",
                "Teleport to the first spawn.",
                authMeCommand);
        firstSpawnCommand.setCommandPermissions("authme.admin.firstspawn", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the setfirstspawn command
        CommandDescription setFirstSpawnCommand = new CommandDescription(
                new SetFirstSpawnCommand(),
                new ArrayList<String>() {{
                    add("setfirstspawn");
                    add("chgfirstspawn");
                }},
                "Change the first spawn",
                "Change the first player's spawn to your current position.",
                authMeCommand);
        setFirstSpawnCommand.setCommandPermissions("authme.admin.setfirstspawn", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the purge command
        CommandDescription purgeCommand = new CommandDescription(
                new PurgeCommand(),
                new ArrayList<String>() {{
                    add("purge");
                    add("delete");
                }},
                "Purge old data",
                "Purge old AuthMeReloaded data longer than the specified amount of days ago.",
                authMeCommand);
        purgeCommand.setCommandPermissions("authme.admin.purge", CommandPermissions.DefaultPermission.OP_ONLY);
        purgeCommand.addArgument(new CommandArgumentDescription("days", "Number of days", false));

        // Register the purgelastposition command
        CommandDescription purgeLastPositionCommand = new CommandDescription(
                new PurgeLastPositionCommand(),
                new ArrayList<String>() {{
                    add("purgelastposition");
                    add("purgelastpos");
                    add("resetposition");
                    add("resetpos");
                    add("resetlastposition");
                    add("resetlastpos");
                }},
                "Purge player's last position",
                "Purge the last know position of the specified player.",
                authMeCommand);
        purgeLastPositionCommand.setCommandPermissions("authme.admin.purgelastpos", CommandPermissions.DefaultPermission.OP_ONLY);
        purgeLastPositionCommand.addArgument(new CommandArgumentDescription("player", "Player name", true));

        // Register the purgebannedplayers command
        CommandDescription purgeBannedPlayersCommand = new CommandDescription(
                new PurgeBannedPlayersCommand(),
                new ArrayList<String>() {{
                    add("purgebannedplayers");
                    add("purgebannedplayer");
                    add("deletebannedplayers");
                    add("deletebannedplayer");
                }},
                "Purge banned palyers data",
                "Purge all AuthMeReloaded data for banned players.",
                authMeCommand);
        purgeBannedPlayersCommand.setCommandPermissions("authme.admin.purgebannedplayers", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the switchantibot command
        CommandDescription switchAntiBotCommand = new CommandDescription(
                new SwitchAntiBotCommand(),
                new ArrayList<String>() {{
                    add("switchantibot");
                    add("toggleantibot");
                    add("antibot");
                }},
                "Switch AntiBot mode",
                "Switch or toggle the AntiBot mode to the specified state.",
                authMeCommand);
        switchAntiBotCommand.setCommandPermissions("authme.admin.switchantibot", CommandPermissions.DefaultPermission.OP_ONLY);
        switchAntiBotCommand.addArgument(new CommandArgumentDescription("mode", "ON / OFF", true));

        // Register the reload command
        CommandDescription reloadCommand = new CommandDescription(
                new ReloadCommand(),
                new ArrayList<String>() {{
                    add("reload");
                    add("rld");
                    add("r");
                }},
                "Reload plugin",
                "Reload the AuthMeReloaded plugin.",
                authMeCommand);
        reloadCommand.setCommandPermissions("authme.admin.reload", CommandPermissions.DefaultPermission.OP_ONLY);

        // Register the version command
        CommandDescription versionCommand = new CommandDescription(
                new VersionCommand(),
                new ArrayList<String>() {{
                    add("version");
                    add("ver");
                    add("v");
                    add("about");
                    add("info");
                }},
                "Version info",
                "Show detailed information about the installed AuthMeReloaded version, and shows the developers, contributors, license and other information.",
                authMeCommand);
        versionCommand.setMaximumArguments(false);

        // Add the base commands to the commands array
        this.commandDescriptions.add(authMeCommand);
    }

    /**
     * Get the list of command descriptions
     *
     * @return List of command descriptions.
     */
    public List<CommandDescription> getCommandDescriptions() {
        return this.commandDescriptions;
    }

    /**
     * Get the number of command description count.
     *
     * @return Command description count.
     */
    public int getCommandDescriptionCount() {
        return this.getCommandDescriptions().size();
    }

    /**
     * Find the best suitable command for the specified reference.
     *
     * @param queryReference The query reference to find a command for.
     *
     * @return The command found, or null.
     */
    public FoundCommandResult findCommand(CommandParts queryReference) {
        // Make sure the command reference is valid
        if(queryReference.getCount() <= 0)
            return null;

        // Get the base command description
        for(CommandDescription commandDescription : this.commandDescriptions) {
            // Check whether there's a command description available for the current command
            if(!commandDescription.isSuitableLabel(queryReference))
                continue;

            // Find the command reference, return the result
            return commandDescription.findCommand(queryReference);
        }

        // No applicable command description found, return false
        return null;
    }
}
