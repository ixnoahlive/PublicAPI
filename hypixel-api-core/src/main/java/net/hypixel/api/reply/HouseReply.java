package net.hypixel.api.reply;

import com.google.gson.annotations.SerializedName;

import java.time.ZonedDateTime;

public class HouseReply extends RateLimitedReply {
    private House house;

    public House getHouse() { return house; }

    @Override
    public String toString() {
        return "HouseReply{" +
                "house=" + house +
                "}" + super.toString();
    }

    public static class House {
        @SerializedName("uuid") // Note: This value isn't valid UUID v4 because it has no dashes.
        private String id;
        @SerializedName("owner")
        private String ownerId;
        @SerializedName("players")
        private Short onlinePlayers;

        // Note: Houses made before full release will show as being made 1st Jan. 1970
        private ZonedDateTime createdAt;
        private HouseCookies cookies;

        /**
         * The house's unique identifier, a 32-character hexadecimal string not to be confused with a UUID.
         * If the house was made during Housing's beta period, it will match the owner's Minecraft ID.
         *
         * @return the house's unique identifier
         */
        public String getId() { return id; }

        /**
         * The house owner's Minecraft ID.
         *
         * @return the house owner's Minecraft ID
         */
        public String getOwnerId() { return ownerId; }

        /**
         * The time of the house's creation, falling back to the 1st of January 1970 if
         * the house was made during Housing's beta period (Aug. 2015 - Mar. 2020).
         *
         * @return the house's time of creation
         */
        public ZonedDateTime getCreatedAt() { return createdAt; }

        /**
         * The house's current online player count.
         *
         * @return the house's live player count
         */
        public Short getOnlinePlayers() { return onlinePlayers; }

        /**
         * The house's metrics relating to the cookies it received from players.
         * This currently only contains the amount for the current week.
         *
         * @return the house's cookie metrics
         */
        public HouseCookies getCookies() { return cookies; }


        public static class HouseCookies {
            private Integer current;

            /**
             * The house's amount of received cookies for the current week, each
             * starting on Sunday, 00:00 Toronto Local Time.
             *
             * @return the amount of cookies this house has received this week
             */
            public Integer getCurrent() { return current; }
        }
    }
}
