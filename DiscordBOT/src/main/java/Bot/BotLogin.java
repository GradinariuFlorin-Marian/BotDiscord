package Bot;

import Utils.TokenManager;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.object.entity.User;

public class BotLogin {
    public static BotLogin instance;
    private GatewayDiscordClient client;

    private BotLogin() {
        String token = TokenManager.getToken();
        if (token.isEmpty()) {
            System.out.println("Token not set!");
        } else {
            client = DiscordClientBuilder.create(token)
                    .build()
                    .login()
                    .block();
            client.getEventDispatcher().on(ReadyEvent.class)
                    .subscribe(event -> {
                        final User self = event.getSelf();
                        System.out.println(String.format(
                                "Logged in as %s#%s", self.getUsername(), self.getDiscriminator()
                        ));
                    });
        }
    }

    public static BotLogin getInstance() {
        if (instance == null) {
            instance = new BotLogin();
        }
        return instance;
    }

    public GatewayDiscordClient getClient() {
        return this.client;
    }
}
