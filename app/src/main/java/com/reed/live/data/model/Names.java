package com.reed.live.data.model;

/**
 * Created by thinkreed on 2017/4/5.
 */

public class Names {

    private String live;
    private String player;

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    private Names(Builder builder) {
        live = builder.live;
        player = builder.player;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@code Names} builder static inner class.
     */
    public static final class Builder {
        private String live;
        private String player;

        private Builder() {
        }

        /**
         * Sets the {@code live} and returns a reference to this Builder so that the methods can be
         * chained together.
         *
         * @param live the {@code live} to set
         * @return a reference to this Builder
         */
        public Builder live(String live) {
            this.live = live;
            return this;
        }

        /**
         * Sets the {@code player} and returns a reference to this Builder so that the methods can
         * be chained together.
         *
         * @param player the {@code player} to set
         * @return a reference to this Builder
         */
        public Builder player(String player) {
            this.player = player;
            return this;
        }

        /**
         * Returns a {@code Names} built from the parameters previously set.
         *
         * @return a {@code Names} built with parameters of this {@code
         * Names.Builder}
         */
        public Names build() {
            return new Names(this);
        }
    }
}
