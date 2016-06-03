package concert;

public class CriticismEnglineImpl implements CriticismEngine {
public CriticismEnglineImpl() {
    
}

public String getCriticism() {
    int i = (int) (Math.random() * criticismPool.length);
    return criticismPool[i];
}

// injected
private String [] criticismPool;

/**
 * @param criticismPool the criticismPool to set
 */
public void setCriticismPool(String[] criticismPool) {
    this.criticismPool = criticismPool;
}

}
