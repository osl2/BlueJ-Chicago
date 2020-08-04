package osl2.messaging.datastructures;

import osl2.messaging.errorHandling.UserError;

public interface DatastructureCommunication {
    void handleError(UserError userError);
    void setName(String name);
}
