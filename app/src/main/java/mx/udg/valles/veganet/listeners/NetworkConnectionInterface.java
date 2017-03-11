package mx.udg.valles.veganet.listeners;

/**
 * Created by veganet on 11/03/2017.
 */

public interface NetworkConnectionInterface {

    void OnSuccesfullyResponse(String response);
    void OnFailedResponse();
}
