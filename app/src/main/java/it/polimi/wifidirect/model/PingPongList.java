package it.polimi.wifidirect.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Stefano Cappa on 01/02/15.
 *
 * Class that represents the list of GO's mac address available to pingpong with the PingPong device client.
 */
public class PingPongList {

    @Getter private List<P2PDevice> pingponglist;

    @Getter @Setter private String ping_macaddress, pong_macaddress;
    @Getter @Setter private boolean testmode;

    @Getter @Setter private P2PDevice pingDevice, pongDevice;

    //Pingpong stops when this attribute is equals to false
    @Getter @Setter private boolean pingponging;

    //used to stop the continuously discovery procedure.
    //The discovery will be restarted by PingPongLogic with the AsyncTask, after the disconnect event.
    @Getter @Setter private boolean connecting;

    //if true this device must use the pong_macaddress, otherwise ping_macaddress
    @Getter @Setter private boolean use_pongAddress;

    private static PingPongList instance = new PingPongList();

    /**
     * Method to get the instance of this class.
     * @return instance of this class.
     */
    public static PingPongList getInstance() {
        return instance;
    }


    /**
     * Private constructor, because is a singleton class.
     */
    private PingPongList () {
        this.pingponglist = new ArrayList<>();
        this.testmode = false;
        this.pingponging = false;
        this.use_pongAddress = true;
        this.connecting = false;
    }

    /**
     * Method to get the next GO to connect, i mean Ping Device or Pong Device, one of them.
     * @return The next {@link it.polimi.wifidirect.model.P2PDevice} found.
     */
    public P2PDevice getNextDeviceToConnect() {
        //i check which is the next go to connect
        if (PingPongList.getInstance().isUse_pongAddress()) {
            PingPongList.getInstance().setUse_pongAddress(false);
            return pongDevice;
        } else {
            PingPongList.getInstance().setUse_pongAddress(true);
            return pingDevice;
        }
    }

}