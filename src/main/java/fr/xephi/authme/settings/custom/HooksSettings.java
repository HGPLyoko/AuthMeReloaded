package fr.xephi.authme.settings.custom;

import fr.xephi.authme.settings.custom.domain.Comment;
import fr.xephi.authme.settings.custom.domain.Property;
import fr.xephi.authme.settings.custom.domain.PropertyType;
import fr.xephi.authme.settings.custom.domain.SettingsClass;

import static fr.xephi.authme.settings.custom.domain.Property.newProperty;

public class HooksSettings implements SettingsClass {

	@Comment("Do we need to hook with multiverse for spawn checking?")
    public static final Property<Boolean> MULTIVERSE =
        newProperty(PropertyType.BOOLEAN, "Hooks.multiverse", true);

	@Comment("Do we need to hook with BungeeCord?")
    public static final Property<Boolean> BUNGEECORD =
        newProperty(PropertyType.BOOLEAN, "Hooks.bungeecord", false);

	@Comment("Send player to this BungeeCord server after register/login")
    public static final Property<String> BUNGEECORD_SERVER =
        newProperty(PropertyType.STRING, "bungeecord.server", "");

	@Comment("Do we need to disable Essentials SocialSpy on join?")
    public static final Property<Boolean> DISABLE_SOCIAL_SPY =
        newProperty(PropertyType.BOOLEAN, "Hooks.disableSocialSpy", false);

	@Comment("Do we need to force /motd Essentials command on join?")
    public static final Property<Boolean> USE_ESSENTIALS_MOTD =
        newProperty(PropertyType.BOOLEAN, "Hooks.useEssentialsMotd", false);

	@Comment("Do we need to cache custom Attributes?")
    public static final Property<Boolean> CACHE_CUSTOM_ATTRIBUTES =
        newProperty(PropertyType.BOOLEAN, "Hooks.customAttributes", false);

    private HooksSettings() {
    }

}
