package com.reed.live.worker.commands;

/**
 * Created by thinkreed on 2017/4/14.
 */

public class CommandExecutor {
  public static void executeCommand(Command command) {
    command.execute();
  }
}
