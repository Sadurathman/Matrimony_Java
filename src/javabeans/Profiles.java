package javabeans;

import java.io.Serializable;
import java.util.Set;

public class Profiles implements Serializable {
  private static final long serialVersionUID = 88L;

  private Set<ProfileInfo> profiles;
  private Set<Integer> ids;

  public Set<ProfileInfo> getProfiles() {
    return this.profiles;
  }

  public void setProfiles(Set<ProfileInfo> profiles) {
    this.profiles = profiles;
  }

  public Set<Integer> getIds() {
    return this.ids;
  }

  public void setIds(Set<Integer> ids) {
    this.ids = ids;
  }

}
