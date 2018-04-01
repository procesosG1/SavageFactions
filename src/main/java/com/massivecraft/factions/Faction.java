package com.massivecraft.factions;

import com.massivecraft.factions.iface.EconomyParticipator;
import com.massivecraft.factions.iface.RelationParticipator;
import com.massivecraft.factions.struct.BanInfo;
import com.massivecraft.factions.struct.Relation;
import com.massivecraft.factions.struct.Role;
import com.massivecraft.factions.util.LazyLocation;
import com.massivecraft.factions.zcore.FLevelPrestiges.Level;
import com.massivecraft.factions.zcore.FLevelPrestiges.Prestige;
import com.massivecraft.factions.zcore.fperms.Access;
import com.massivecraft.factions.zcore.fperms.Permissable;
import com.massivecraft.factions.zcore.fperms.PermissableAction;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public interface Faction extends EconomyParticipator {
    public HashMap<String, List<String>> getAnnouncements();

    public ConcurrentHashMap<String, LazyLocation> getWarps();

    public LazyLocation getWarp(String name);

    public void setWarp(String name, LazyLocation loc);

    public boolean isWarp(String name);

    public boolean hasWarpPassword(String warp);

    public boolean isWarpPassword(String warp, String password);

    public void setWarpPassword(String warp, String password);

    public boolean removeWarp(String name);

    public void clearWarps();

    public int getMaxVaults();

    public void setMaxVaults(int value);

    public void addAnnouncement(FPlayer fPlayer, String msg);

    public void sendUnreadAnnouncements(FPlayer fPlayer);

    public void removeAnnouncements(FPlayer fPlayer);

    public Set<String> getInvites();

    public String getId();

    public void invite(FPlayer fplayer);

    public void deinvite(FPlayer fplayer);

    public void setUpgrades(String key, int level);

    public int getUpgrade(String key);

    public boolean isInvited(FPlayer fplayer);

    public void ban(FPlayer target, FPlayer banner);

    public void unban(FPlayer player);

    public boolean isBanned(FPlayer player);

    public Set<BanInfo> getBannedPlayers();

    public HashMap<Integer,String> getRulesMap();

    public void setRule(int index, String rule);

    public void addRule(String rule);

    public void removeRule(int index);

    public void clearRules();

    public void setCheckpoint(Location location);

    public Location getCheckpoint();

    public void addTnt(int amt);

    public void takeTnt(int amt);

    public Location getVault();

    public void setVault(Location vaultLocation);

    public int getTnt();

    public String getRule(int index);

    public boolean getOpen();

    public void setOpen(boolean isOpen);

    public boolean isPeaceful();

    public void setPeaceful(boolean isPeaceful);

    public void setPeacefulExplosionsEnabled(boolean val);

    public boolean getPeacefulExplosionsEnabled();

    public boolean noExplosionsInTerritory();

    public boolean isPermanent();

    public void setPermanent(boolean isPermanent);

    public String getTag();

    public String getTag(String prefix);

    public String getTag(Faction otherFaction);

    public String getTag(FPlayer otherFplayer);

    public void setTag(String str);

    public String getComparisonTag();

    public String getDescription();

    public void setDescription(String value);

    public void setHome(Location home);

    public boolean hasHome();

    public Location getHome();

    public long getFoundedDate();

    public void setFoundedDate(long newDate);

    public void confirmValidHome();

    public String getAccountId();

    public Integer getPermanentPower();

    public void setPermanentPower(Integer permanentPower);

    public boolean hasPermanentPower();

    public double getPowerBoost();

    public void setPowerBoost(double powerBoost);

    public boolean noPvPInTerritory();

    public boolean noMonstersInTerritory();

    public boolean isNormal();

    @Deprecated
    public boolean isNone();

    public boolean isWilderness();

    public boolean isSafeZone();

    public boolean isWarZone();

    public boolean isPlayerFreeType();

    public boolean isPowerFrozen();

    public void setLastDeath(long time);

    public int getKills();

    public int getDeaths();

    public Access getAccess(Permissable permissable, PermissableAction permissableAction);

    public Access getAccess(FPlayer player, PermissableAction permissableAction);

    public void setPermission(Permissable permissable, PermissableAction permissableAction, Access access);

    public void resetPerms();

    public Map<Permissable, Map<PermissableAction, Access>> getPermissions();

    // -------------------------------
    // Relation and relation colors
    // -------------------------------

    @Override
    public String describeTo(RelationParticipator that, boolean ucfirst);

    @Override
    public String describeTo(RelationParticipator that);

    @Override
    public Relation getRelationTo(RelationParticipator rp);

    @Override
    public Relation getRelationTo(RelationParticipator rp, boolean ignorePeaceful);

    @Override
    public ChatColor getColorTo(RelationParticipator rp);

    public Relation getRelationWish(Faction otherFaction);

    public void setRelationWish(Faction otherFaction, Relation relation);

    public int getRelationCount(Relation relation);

    // ----------------------------------------------//
    // Power
    // ----------------------------------------------//
    public double getPower();

    public double getPowerMax();

    public int getPowerRounded();

    public int getPowerMaxRounded();

    public int getLandRounded();

    public int getLandRoundedInWorld(String worldName);

    public boolean hasLandInflation();

    // -------------------------------
    // FPlayers
    // -------------------------------

    // maintain the reference list of FPlayers in this faction
    public void refreshFPlayers();

    public boolean addFPlayer(FPlayer fplayer);

    public boolean removeFPlayer(FPlayer fplayer);

    public int getSize();

    public Set<FPlayer> getFPlayers();

    public Set<FPlayer> getFPlayersWhereOnline(boolean online);

    public Set<FPlayer> getFPlayersWhereOnline(boolean online, FPlayer viewer);

    public FPlayer getFPlayerAdmin();

    public ArrayList<FPlayer> getFPlayersWhereRole(Role role);

    public ArrayList<Player> getOnlinePlayers();

    // slightly faster check than getOnlinePlayers() if you just want to see if
    // there are any players online
    public boolean hasPlayersOnline();

    public void memberLoggedOff();

    // used when current leader is about to be removed from the faction;
    // promotes new leader, or disbands faction if no other members left
    public void promoteNewLeader();

    public Role getDefaultRole();

    public void setDefaultRole(Role role);

    // ----------------------------------------------//
    // Messages
    // ----------------------------------------------//
    public void msg(String message, Object... args);

    public void sendMessage(String message);

    public void sendMessage(List<String> messages);

    // ----------------------------------------------//
    // Ownership of specific claims
    // ----------------------------------------------//

    public Map<FLocation, Set<String>> getClaimOwnership();

    public void clearAllClaimOwnership();

    public void clearClaimOwnership(FLocation loc);

    public void clearClaimOwnership(FPlayer player);

    public int getCountOfClaimsWithOwners();

    public boolean doesLocationHaveOwnersSet(FLocation loc);

    public boolean isPlayerInOwnerList(FPlayer player, FLocation loc);

    public void setPlayerAsOwner(FPlayer player, FLocation loc);

    public void removePlayerAsOwner(FPlayer player, FLocation loc);

    public Set<String> getOwnerList(FLocation loc);

    public String getOwnerListString(FLocation loc);

    public boolean playerHasOwnershipRights(FPlayer fplayer, FLocation loc);

    // ----------------------------------------------//
    // Persistance and entity management
    // ----------------------------------------------//
    public void remove();

    public Set<FLocation> getAllClaims();

    public void setId(String id);




    ////////////// FACTION PRESTIGES /////////////////




    public Prestige getPrestige();
    public Level getLevel();
    public void setPrestige(Prestige prestige);
    public void setLevel(Level level);

    public void levelUp();
    public void levelDown();
    public void prestigeUp();
    public void prestigeDown();

    public int getLevelPoints();
    public void setLevelPoints(int levelPoints);
    public void addLevelPoints(int levelPoints);
    public void takeLevelPoints(int levelPoints);

    public boolean isPrestige(Prestige prestige);
    public boolean isLevel(Level level);

    public boolean isMaxPrestige();
    public boolean isMaxLevel();

    public boolean isMinLevel();
    public boolean isMinPrestige();


    public void broadCastMessage(String message);


    ////////////////////////////////////////////////////



    ////////////// KOTH //////////////////////////////////


    public int getKothWins();
    public void setKothWins(int wins);
    public void addKothWin();


    /////////////////////////////////////////////////////////


    /////////////// ANTIGRIND STUFF ////////////////////////



    ///////////////////////////////////////////////////////

}
