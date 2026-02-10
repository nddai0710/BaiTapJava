package data;

import java.io.Serializable;
import java.util.Objects;

public abstract class AssetID implements Serializable {
    protected String id;

    public AssetID(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return this.id.equalsIgnoreCase(((AssetID)o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
