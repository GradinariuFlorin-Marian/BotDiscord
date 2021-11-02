
import Bot.BotLogin;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, String> cmds = new HashMap<>();
    public static void main(String[] args) {
        GatewayDiscordClient client = BotLogin.getInstance().getClient();
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase("!ping pong"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("test"))
                .subscribe();
        client.onDisconnect().block();
    }
}
