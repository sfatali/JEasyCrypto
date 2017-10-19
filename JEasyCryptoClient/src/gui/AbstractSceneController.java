package gui;

public abstract class AbstractSceneController {
    private int id;
    private SceneManager manager;

    public AbstractSceneController(int id, SceneManager manager) {
        this.id = id;
        this.manager = manager;
    }

    protected void notifyClosure(Object returnObj){
        manager.handleSceneClose(id, returnObj);
    }
}