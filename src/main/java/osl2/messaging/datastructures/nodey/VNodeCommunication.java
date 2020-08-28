package osl2.messaging.datastructures.nodey;

import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.nodey.GuiNode;

public interface VNodeCommunication<T> extends DatastructureCommunication {
  GuiNode asGuiNode();

  void valueChange(T newValue);
}
