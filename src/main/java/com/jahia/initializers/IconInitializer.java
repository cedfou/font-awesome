/**
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2018 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
 */
package com.jahia.initializers;

import org.jahia.services.content.JCRPropertyWrapper;
import org.jahia.services.content.nodetypes.ExtendedPropertyDefinition;
import org.jahia.services.content.nodetypes.initializers.ChoiceListValue;
import org.jahia.services.content.nodetypes.initializers.ModuleChoiceListInitializer;
import org.jahia.services.content.nodetypes.renderer.AbstractChoiceListRenderer;
import org.jahia.services.content.nodetypes.renderer.ModuleChoiceListRenderer;
import org.jahia.services.render.RenderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class IconInitializer extends AbstractChoiceListRenderer implements ModuleChoiceListInitializer, ModuleChoiceListRenderer {

    private static final Logger logger = LoggerFactory.getLogger(IconInitializer.class);

    private String key;

    /**
     * {@inheritDoc}
     */
    protected static final String[] ICONS = {"fa-500px",
            "fa-accessible-icon",
            "fa-accusoft",
            "fa-address-book",
            "fa-address-card",
            "fa-adjust",
            "fa-adn",
            "fa-adversal",
            "fa-affiliatetheme",
            "fa-algolia",
            "fa-align-center",
            "fa-align-justify",
            "fa-align-left",
            "fa-align-right",
            "fa-amazon",
            "fa-amazon-pay",
            "fa-ambulance",
            "fa-american-sign-language-interpreting",
            "fa-amilia",
            "fa-anchor",
            "fa-android",
            "fa-angellist",
            "fa-angle-double-down",
            "fa-angle-double-left",
            "fa-angle-double-right",
            "fa-angle-double-up",
            "fa-angle-down",
            "fa-angle-left",
            "fa-angle-right",
            "fa-angle-up",
            "fa-angrycreative",
            "fa-angular",
            "fa-apper",
            "fa-apple",
            "fa-apple-pay",
            "fa-app-store",
            "fa-app-store-ios",
            "fa-archive",
            "fa-arrow-alt-circle-down",
            "fa-arrow-alt-circle-left",
            "fa-arrow-alt-circle-right",
            "fa-arrow-alt-circle-up",
            "fa-arrow-circle-down",
            "fa-arrow-circle-left",
            "fa-arrow-circle-right",
            "fa-arrow-circle-up",
            "fa-arrow-down",
            "fa-arrow-left",
            "fa-arrow-right",
            "fa-arrows-alt",
            "fa-arrows-alt-h",
            "fa-arrows-alt-v",
            "fa-arrow-up",
            "fa-assistive-listening-systems",
            "fa-asterisk",
            "fa-asymmetrik",
            "fa-at",
            "fa-audible",
            "fa-audio-description",
            "fa-autoprefixer",
            "fa-avianex",
            "fa-aviato",
            "fa-aws",
            "fa-backward",
            "fa-balance-scale",
            "fa-ban",
            "fa-bandcamp",
            "fa-barcode",
            "fa-bars",
            "fa-bath",
            "fa-battery-empty",
            "fa-battery-full",
            "fa-battery-half",
            "fa-battery-quarter",
            "fa-battery-three-quarters",
            "fa-bed",
            "fa-beer",
            "fa-behance",
            "fa-behance-square",
            "fa-bell",
            "fa-bell-slash",
            "fa-bicycle",
            "fa-bimobject",
            "fa-binoculars",
            "fa-birthday-cake",
            "fa-bitbucket",
            "fa-bitcoin",
            "fa-bity",
            "fa-blackberry",
            "fa-black-tie",
            "fa-blind",
            "fa-blogger-b",
            "fa-blogger",
            "fa-bluetooth-b",
            "fa-bluetooth",
            "fa-bold",
            "fa-bolt",
            "fa-bomb",
            "fa-book",
            "fa-bookmark",
            "fa-braille",
            "fa-briefcase",
            "fa-btc",
            "fa-bug",
            "fa-building",
            "fa-bullhorn",
            "fa-bullseye",
            "fa-buromobelexperte",
            "fa-bus",
            "fa-buysellads",
            "fa-calculator",
            "fa-calendar-alt",
            "fa-calendar",
            "fa-calendar-check",
            "fa-calendar-minus",
            "fa-calendar-plus",
            "fa-calendar-times",
            "fa-camera",
            "fa-camera-retro",
            "fa-car",
            "fa-caret-down",
            "fa-caret-left",
            "fa-caret-right",
            "fa-caret-square-down",
            "fa-caret-square-left",
            "fa-caret-square-right",
            "fa-caret-square-up",
            "fa-caret-up",
            "fa-cart-arrow-down",
            "fa-cart-plus",
            "fa-cc-amazon-pay",
            "fa-cc-amex",
            "fa-cc-apple-pay",
            "fa-cc-diners-club",
            "fa-cc-discover",
            "fa-cc-jcb",
            "fa-cc-mastercard",
            "fa-cc-paypal",
            "fa-cc-stripe",
            "fa-cc-visa",
            "fa-centercode",
            "fa-certificate",
            "fa-chart-area",
            "fa-chart-bar",
            "fa-chart-line",
            "fa-chart-pie",
            "fa-check",
            "fa-check-circle",
            "fa-check-square",
            "fa-chevron-circle-down",
            "fa-chevron-circle-left",
            "fa-chevron-circle-right",
            "fa-chevron-circle-up",
            "fa-chevron-down",
            "fa-chevron-left",
            "fa-chevron-right",
            "fa-chevron-up",
            "fa-child",
            "fa-chrome",
            "fa-circle",
            "fa-circle-notch",
            "fa-clipboard",
            "fa-clock",
            "fa-clone",
            "fa-closed-captioning",
            "fa-cloud",
            "fa-cloud-download-alt",
            "fa-cloudscale",
            "fa-cloudsmith",
            "fa-cloud-upload-alt",
            "fa-cloudversify",
            "fa-code",
            "fa-code-branch",
            "fa-codepen",
            "fa-codiepie",
            "fa-coffee",
            "fa-cog",
            "fa-cogs",
            "fa-columns",
            "fa-comment-alt",
            "fa-comment",
            "fa-comments",
            "fa-compass",
            "fa-compress",
            "fa-connectdevelop",
            "fa-contao",
            "fa-copy",
            "fa-copyright",
            "fa-cpanel",
            "fa-creative-commons",
            "fa-credit-card",
            "fa-crop",
            "fa-crosshairs",
            "fa-css3-alt",
            "fa-css3",
            "fa-cube",
            "fa-cubes",
            "fa-cut",
            "fa-cuttlefish",
            "fa-d-and-d",
            "fa-dashcube",
            "fa-database",
            "fa-deaf",
            "fa-delicious",
            "fa-deploydog",
            "fa-deskpro",
            "fa-desktop",
            "fa-deviantart",
            "fa-digg",
            "fa-digital-ocean",
            "fa-discord",
            "fa-discourse",
            "fa-dochub",
            "fa-docker",
            "fa-dollar-sign",
            "fa-dot-circle",
            "fa-download",
            "fa-draft2digital",
            "fa-dribbble",
            "fa-dribbble-square",
            "fa-dropbox",
            "fa-drupal",
            "fa-dyalog",
            "fa-earlybirds",
            "fa-edge",
            "fa-edit",
            "fa-eject",
            "fa-elementor",
            "fa-ellipsis-h",
            "fa-ellipsis-v",
            "fa-ember",
            "fa-empire",
            "fa-envelope",
            "fa-envelope-open",
            "fa-envelope-square",
            "fa-envira",
            "fa-eraser",
            "fa-erlang",
            "fa-ethereum",
            "fa-etsy",
            "fa-euro-sign",
            "fa-exchange-alt",
            "fa-exclamation",
            "fa-exclamation-circle",
            "fa-exclamation-triangle",
            "fa-expand-arrows-alt",
            "fa-expand",
            "fa-expeditedssl",
            "fa-external-link-alt",
            "fa-external-link-square-alt",
            "fa-eye",
            "fa-eye-dropper",
            "fa-eye-slash",
            "fa-facebook",
            "fa-facebook-f",
            "fa-facebook-messenger",
            "fa-facebook-square",
            "fa-fast-backward",
            "fa-fast-forward",
            "fa-fax",
            "fa-female",
            "fa-fighter-jet",
            "fa-file-alt",
            "fa-file-archive",
            "fa-file-audio",
            "fa-file",
            "fa-file-code",
            "fa-file-excel",
            "fa-file-image",
            "fa-file-pdf",
            "fa-file-powerpoint",
            "fa-file-video",
            "fa-file-word",
            "fa-film",
            "fa-filter",
            "fa-fire",
            "fa-fire-extinguisher",
            "fa-firefox",
            "fa-firstdraft",
            "fa-first-order",
            "fa-flag",
            "fa-flag-checkered",
            "fa-flask",
            "fa-flickr",
            "fa-fly",
            "fa-folder",
            "fa-folder-open",
            "fa-font-awesome-alt",
            "fa-font-awesome",
            "fa-font-awesome-flag",
            "fa-font",
            "fa-fonticons",
            "fa-fonticons-fi",
            "fa-fort-awesome-alt",
            "fa-fort-awesome",
            "fa-forumbee",
            "fa-forward",
            "fa-foursquare",
            "fa-freebsd",
            "fa-free-code-camp",
            "fa-frown",
            "fa-futbol",
            "fa-gamepad",
            "fa-gavel",
            "fa-gem",
            "fa-genderless",
            "fa-get-pocket",
            "fa-gg",
            "fa-gg-circle",
            "fa-gift",
            "fa-git",
            "fa-github-alt",
            "fa-github",
            "fa-github-square",
            "fa-gitkraken",
            "fa-gitlab",
            "fa-git-square",
            "fa-gitter",
            "fa-glass-martini",
            "fa-glide",
            "fa-glide-g",
            "fa-globe",
            "fa-gofore",
            "fa-goodreads",
            "fa-goodreads-g",
            "fa-google",
            "fa-google-drive",
            "fa-google-play",
            "fa-google-plus",
            "fa-google-plus-g",
            "fa-google-plus-square",
            "fa-google-wallet",
            "fa-graduation-cap",
            "fa-gratipay",
            "fa-grav",
            "fa-gripfire",
            "fa-grunt",
            "fa-gulp",
            "fa-hacker-news",
            "fa-hacker-news-square",
            "fa-hand-lizard",
            "fa-hand-paper",
            "fa-hand-peace",
            "fa-hand-point-down",
            "fa-hand-pointer",
            "fa-hand-point-left",
            "fa-hand-point-right",
            "fa-hand-point-up",
            "fa-hand-rock",
            "fa-hand-scissors",
            "fa-handshake",
            "fa-hand-spock",
            "fa-hashtag",
            "fa-hdd",
            "fa-heading",
            "fa-headphones",
            "fa-heartbeat",
            "fa-heart",
            "fa-hire-a-helper",
            "fa-history",
            "fa-home",
            "fa-hooli",
            "fa-hospital",
            "fa-hotjar",
            "fa-hourglass",
            "fa-hourglass-end",
            "fa-hourglass-half",
            "fa-hourglass-start",
            "fa-houzz",
            "fa-h-square",
            "fa-html5",
            "fa-hubspot",
            "fa-i-cursor",
            "fa-id-badge",
            "fa-id-card",
            "fa-image",
            "fa-images",
            "fa-imdb",
            "fa-inbox",
            "fa-indent",
            "fa-industry",
            "fa-info",
            "fa-info-circle",
            "fa-instagram",
            "fa-internet-explorer",
            "fa-ioxhost",
            "fa-italic",
            "fa-itunes",
            "fa-itunes-note",
            "fa-jenkins",
            "fa-joget",
            "fa-joomla",
            "fa-js",
            "fa-jsfiddle",
            "fa-js-square",
            "fa-key",
            "fa-keyboard",
            "fa-keycdn",
            "fa-kickstarter",
            "fa-kickstarter-k",
            "fa-korvue",
            "fa-language",
            "fa-laptop",
            "fa-laravel",
            "fa-lastfm",
            "fa-lastfm-square",
            "fa-leaf",
            "fa-leanpub",
            "fa-lemon",
            "fa-less",
            "fa-level-down-alt",
            "fa-level-up-alt",
            "fa-life-ring",
            "fa-lightbulb",
            "fa-line",
            "fa-link",
            "fa-linkedin",
            "fa-linkedin-in",
            "fa-linode",
            "fa-linux",
            "fa-lira-sign",
            "fa-list-alt",
            "fa-list",
            "fa-list-ol",
            "fa-list-ul",
            "fa-location-arrow",
            "fa-lock",
            "fa-lock-open",
            "fa-long-arrow-alt-down",
            "fa-long-arrow-alt-left",
            "fa-long-arrow-alt-right",
            "fa-long-arrow-alt-up",
            "fa-low-vision",
            "fa-lyft",
            "fa-magento",
            "fa-magic",
            "fa-magnet",
            "fa-male",
            "fa-map",
            "fa-map-marker-alt",
            "fa-map-marker",
            "fa-map-pin",
            "fa-map-signs",
            "fa-mars",
            "fa-mars-double",
            "fa-mars-stroke",
            "fa-mars-stroke-h",
            "fa-mars-stroke-v",
            "fa-maxcdn",
            "fa-medapps",
            "fa-medium",
            "fa-medium-m",
            "fa-medkit",
            "fa-medrt",
            "fa-meetup",
            "fa-meh",
            "fa-mercury",
            "fa-microchip",
            "fa-microphone",
            "fa-microphone-slash",
            "fa-microsoft",
            "fa-minus",
            "fa-minus-circle",
            "fa-minus-square",
            "fa-mix",
            "fa-mixcloud",
            "fa-mizuni",
            "fa-mobile-alt",
            "fa-mobile",
            "fa-modx",
            "fa-monero",
            "fa-money-bill-alt",
            "fa-moon",
            "fa-motorcycle",
            "fa-mouse-pointer",
            "fa-music",
            "fa-napster",
            "fa-neuter",
            "fa-newspaper",
            "fa-nintendo-switch",
            "fa-node",
            "fa-node-js",
            "fa-npm",
            "fa-ns8",
            "fa-nutritionix",
            "fa-object-group",
            "fa-object-ungroup",
            "fa-odnoklassniki",
            "fa-odnoklassniki-square",
            "fa-opencart",
            "fa-openid",
            "fa-opera",
            "fa-optin-monster",
            "fa-osi",
            "fa-outdent",
            "fa-page4",
            "fa-pagelines",
            "fa-paint-brush",
            "fa-palfed",
            "fa-paperclip",
            "fa-paper-plane",
            "fa-paragraph",
            "fa-paste",
            "fa-patreon",
            "fa-pause",
            "fa-pause-circle",
            "fa-paw",
            "fa-paypal",
            "fa-pencil-alt",
            "fa-pen-square",
            "fa-percent",
            "fa-periscope",
            "fa-phabricator",
            "fa-phoenix-framework",
            "fa-phone",
            "fa-phone-square",
            "fa-phone-volume",
            "fa-pied-piper-alt",
            "fa-pied-piper",
            "fa-pied-piper-pp",
            "fa-pinterest",
            "fa-pinterest-p",
            "fa-pinterest-square",
            "fa-plane",
            "fa-play",
            "fa-play-circle",
            "fa-playstation",
            "fa-plug",
            "fa-plus",
            "fa-plus-circle",
            "fa-plus-square",
            "fa-podcast",
            "fa-pound-sign",
            "fa-power-off",
            "fa-print",
            "fa-product-hunt",
            "fa-pushed",
            "fa-puzzle-piece",
            "fa-python",
            "fa-qq",
            "fa-qrcode",
            "fa-question",
            "fa-question-circle",
            "fa-quora",
            "fa-quote-left",
            "fa-quote-right",
            "fa-random",
            "fa-ravelry",
            "fa-react",
            "fa-rebel",
            "fa-recycle",
            "fa-reddit-alien",
            "fa-reddit",
            "fa-reddit-square",
            "fa-redo-alt",
            "fa-redo",
            "fa-red-river",
            "fa-registered",
            "fa-rendact",
            "fa-renren",
            "fa-reply-all",
            "fa-reply",
            "fa-replyd",
            "fa-resolving",
            "fa-retweet",
            "fa-road",
            "fa-rocket",
            "fa-rocketchat",
            "fa-rockrms",
            "fa-rss",
            "fa-rss-square",
            "fa-ruble-sign",
            "fa-rupee-sign",
            "fa-safari",
            "fa-sass",
            "fa-save",
            "fa-schlix",
            "fa-scribd",
            "fa-search",
            "fa-searchengin",
            "fa-search-minus",
            "fa-search-plus",
            "fa-sellcast",
            "fa-sellsy",
            "fa-server",
            "fa-servicestack",
            "fa-share-alt",
            "fa-share-alt-square",
            "fa-share",
            "fa-share-square",
            "fa-shekel-sign",
            "fa-shield-alt",
            "fa-ship",
            "fa-shirtsinbulk",
            "fa-shopping-bag",
            "fa-shopping-basket",
            "fa-shopping-cart",
            "fa-shower",
            "fa-signal",
            "fa-sign-in-alt",
            "fa-sign-language",
            "fa-sign-out-alt",
            "fa-simplybuilt",
            "fa-sistrix",
            "fa-sitemap",
            "fa-skyatlas",
            "fa-skype",
            "fa-slack",
            "fa-slack-hash",
            "fa-sliders-h",
            "fa-slideshare",
            "fa-smile",
            "fa-snapchat",
            "fa-snapchat-ghost",
            "fa-snapchat-square",
            "fa-snowflake",
            "fa-sort-alpha-down",
            "fa-sort-alpha-up",
            "fa-sort-amount-down",
            "fa-sort-amount-up",
            "fa-sort",
            "fa-sort-down",
            "fa-sort-numeric-down",
            "fa-sort-numeric-up",
            "fa-sort-up",
            "fa-soundcloud",
            "fa-space-shuttle",
            "fa-speakap",
            "fa-spinner",
            "fa-spotify",
            "fa-square",
            "fa-stack-exchange",
            "fa-stack-overflow",
            "fa-star",
            "fa-star-half",
            "fa-staylinked",
            "fa-steam",
            "fa-steam-square",
            "fa-steam-symbol",
            "fa-step-backward",
            "fa-step-forward",
            "fa-stethoscope",
            "fa-sticker-mule",
            "fa-sticky-note",
            "fa-stop",
            "fa-stop-circle",
            "fa-stopwatch",
            "fa-strava",
            "fa-street-view",
            "fa-strikethrough",
            "fa-stripe",
            "fa-stripe-s",
            "fa-studiovinari",
            "fa-stumbleupon",
            "fa-stumbleupon-circle",
            "fa-subscript",
            "fa-subway",
            "fa-suitcase",
            "fa-sun",
            "fa-superpowers",
            "fa-superscript",
            "fa-supple",
            "fa-sync-alt",
            "fa-sync",
            "fa-table",
            "fa-tablet-alt",
            "fa-tablet",
            "fa-tachometer-alt",
            "fa-tag",
            "fa-tags",
            "fa-tasks",
            "fa-taxi",
            "fa-telegram",
            "fa-telegram-plane",
            "fa-tencent-weibo",
            "fa-terminal",
            "fa-text-height",
            "fa-text-width",
            "fa-th",
            "fa-themeisle",
            "fa-thermometer-empty",
            "fa-thermometer-full",
            "fa-thermometer-half",
            "fa-thermometer-quarter",
            "fa-thermometer-three-quarters",
            "fa-th-large",
            "fa-th-list",
            "fa-thumbs-down",
            "fa-thumbs-up",
            "fa-thumbtack",
            "fa-ticket-alt",
            "fa-times",
            "fa-times-circle",
            "fa-tint",
            "fa-toggle-off",
            "fa-toggle-on",
            "fa-trademark",
            "fa-train",
            "fa-transgender-alt",
            "fa-transgender",
            "fa-trash-alt",
            "fa-trash",
            "fa-tree",
            "fa-trello",
            "fa-tripadvisor",
            "fa-trophy",
            "fa-truck",
            "fa-tty",
            "fa-tumblr",
            "fa-tumblr-square",
            "fa-tv",
            "fa-twitch",
            "fa-twitter",
            "fa-twitter-square",
            "fa-typo3",
            "fa-uber",
            "fa-uikit",
            "fa-umbrella",
            "fa-underline",
            "fa-undo-alt",
            "fa-undo",
            "fa-uniregistry",
            "fa-universal-access",
            "fa-university",
            "fa-unlink",
            "fa-unlock-alt",
            "fa-unlock",
            "fa-untappd",
            "fa-upload",
            "fa-usb",
            "fa-user",
            "fa-user-circle",
            "fa-user-md",
            "fa-user-plus",
            "fa-users",
            "fa-user-secret",
            "fa-user-times",
            "fa-ussunnah",
            "fa-utensils",
            "fa-utensil-spoon",
            "fa-vaadin",
            "fa-venus",
            "fa-venus-double",
            "fa-venus-mars",
            "fa-viacoin",
            "fa-viadeo",
            "fa-viadeo-square",
            "fa-viber",
            "fa-video",
            "fa-vimeo",
            "fa-vimeo-square",
            "fa-vimeo-v",
            "fa-vine",
            "fa-vk",
            "fa-vnv",
            "fa-volume-down",
            "fa-volume-off",
            "fa-volume-up",
            "fa-vuejs",
            "fa-weibo",
            "fa-weixin",
            "fa-whatsapp",
            "fa-whatsapp-square",
            "fa-wheelchair",
            "fa-whmcs",
            "fa-wifi",
            "fa-wikipedia-w",
            "fa-window-close",
            "fa-window-maximize",
            "fa-window-minimize",
            "fa-window-restore",
            "fa-windows",
            "fa-won-sign",
            "fa-wordpress",
            "fa-wordpress-simple",
            "fa-wpbeginner",
            "fa-wpexplorer",
            "fa-wpforms",
            "fa-wrench",
            "fa-xbox",
            "fa-xing",
            "fa-xing-square",
            "fa-yahoo",
            "fa-yandex",
            "fa-yandex-international",
            "fa-y-combinator",
            "fa-yelp",
            "fa-yen-sign",
            "fa-yoast",
            "fa-youtube",
            "fa-youtube-square"
    };


    public List<ChoiceListValue> getChoiceListValues(ExtendedPropertyDefinition epd, String param, List<ChoiceListValue> values, Locale locale, Map<String, Object> context) {
        ArrayList<ChoiceListValue> results = new ArrayList<ChoiceListValue>();
        for (String t : ICONS) {
            results.add(new ChoiceListValue(t, t));
        }
        return results;
    }

    /**
     * {@inheritDoc}
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * {@inheritDoc}
     */
    public String getKey() {
        return key;
    }

    /**
     * {@inheritDoc}
     */
    public String getStringRendering(RenderContext context, JCRPropertyWrapper propertyWrapper) throws RepositoryException {
        final StringBuilder sb = new StringBuilder();

        if (propertyWrapper.isMultiple()) {
            sb.append('{');
            final Value[] values = propertyWrapper.getValues();
            for (Value value : values) {
                sb.append('[').append(value.getString()).append(']');
            }
            sb.append('}');
        } else {
            sb.append('[').append(propertyWrapper.getValue().getString()).append(']');
        }

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String getStringRendering(Locale locale, ExtendedPropertyDefinition propDef, Object propertyValue) throws RepositoryException {
        return "[" + propertyValue.toString() + "]";
    }
}
