package io.searchbox.snapshot;

/*Generated by MPS */


public class CreateSnapshot extends AbstractSnapshotAction {

  protected CreateSnapshot(CreateSnapshot.Builder builder) {
    super(builder);
    this.payload = builder.settings;
  }
  @Override
  public String getRestMethodName() {
    return "PUT";
  }
  public static class Builder extends AbstractSnapshotAction.SingleSnapshotBuilder<CreateSnapshot, CreateSnapshot.Builder> {
    private Object settings;
    public Builder(String repository, String snapshot) {
      super(repository, snapshot);
    }
    public CreateSnapshot.Builder settings(Object settings) {
      this.settings = settings;
      return this;
    }
    public CreateSnapshot.Builder waitForCompletion(boolean waitForCompletion) {
      return setParameter("wait_for_completion", waitForCompletion);
    }
    @Override
    public CreateSnapshot build() {
      return new CreateSnapshot(this);
    }
  }
}
