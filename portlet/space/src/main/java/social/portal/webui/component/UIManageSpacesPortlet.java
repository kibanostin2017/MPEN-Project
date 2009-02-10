/*
 * Copyright (C) 2003-2007 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package social.portal.webui.component;

import org.exoplatform.webui.application.WebuiRequestContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIPopupContainer;
import org.exoplatform.webui.core.UIPopupMessages;
import org.exoplatform.webui.core.UIPortletApplication;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
/**
 * Created by The eXo Platform SARL
 * Author : dang.tung
 *          tungcnw@gmail.com
 * August 27, 2008          
 */

@ComponentConfig(
    lifecycle = UIApplicationLifecycle.class, 
    template = "app:/groovy/portal/webui/component/UIManageSpacesPortlet.gtmpl"
)
public class UIManageSpacesPortlet extends UIPortletApplication {

  public UIManageSpacesPortlet() throws Exception {
    addChild(UIPopupContainer.class, null, "ManageSpacesPopup");
    addChild(UISpacesManage.class,null , null);
  }
  
  public void renderPopupMessages() throws Exception {
    UIPopupMessages uiPopupMsg = getUIPopupMessages();
    if(uiPopupMsg == null)  return ;
    WebuiRequestContext  context =  WebuiRequestContext.getCurrentInstance() ;
    uiPopupMsg.processRender(context);
  }
}
