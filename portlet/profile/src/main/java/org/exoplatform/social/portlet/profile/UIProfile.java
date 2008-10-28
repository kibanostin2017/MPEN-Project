package org.exoplatform.social.portlet.profile;

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.exoplatform.webui.core.UIContainer;
import org.exoplatform.social.core.identity.model.Profile;
import org.exoplatform.social.core.identity.model.Identity;
import org.exoplatform.social.core.identity.IdentityManager;
import org.exoplatform.social.portlet.URLUtils;
import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.web.application.RequestContext;
import org.exoplatform.portal.webui.portal.UIPortal;
import org.exoplatform.portal.webui.util.Util;
import org.exoplatform.portal.application.PortalRequestContext;

import java.util.List;
import java.util.ArrayList;


@ComponentConfig(
    lifecycle = UIApplicationLifecycle.class,
    template = "app:/groovy/portal/webui/component/UIProfile.gtmpl"
)
public class UIProfile extends UIContainer {

  public UIProfile() throws Exception {
    List sections = getSections();
    java.util.Iterator it = sections.iterator();
    while (it.hasNext()) {
      Class sect = (Class) it.next();
      addChild(sect, null, null);
    }
  }


  /**
   *
   * @return the list of sections ordered by display order
   */
  private List getSections() {
    List sects = new ArrayList();
    sects.add(UIHeaderSection.class);
    sects.add(UIBasicInfoSection.class);
    sects.add(UIContactSection.class);
    sects.add(UIExperienceSection.class);
    return sects;
  }


  public Profile getProfile() throws Exception {
    ExoContainer container = ExoContainerContext.getCurrentContainer();
    IdentityManager im = (IdentityManager) container.getComponentInstanceOfType(IdentityManager.class);
    Identity id = im.getIdentityByRemoteId("organization", getCurrentProfileID());

    if(id == null)
      return null;
    else
      return id.getProfile();
  }

  public boolean isEditable() {
    RequestContext context = RequestContext.getCurrentInstance();
    String rUser = context.getRemoteUser();

    if(rUser == null)
      return false;

    return getCurrentProfileID().equals(rUser);
  }

  private String getCurrentProfileID() {
    String username = URLUtils.getCurrentUser();
    if(username != null)
      return username;

    // if we are not on the page of a user, we display the profile of the current user
    RequestContext context = RequestContext.getCurrentInstance();
    return context.getRemoteUser();
  }
}
