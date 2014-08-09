/*******************************************************************************
 * Copyhacked (H) 2012-2014.
 * This program and the accompanying materials
 * are made available under no term at all, use it like
 * you want, but share and discuss about it
 * every time possible with every body.
 * 
 * Contributors:
 *      ron190 at ymail dot com - initial implementation
 ******************************************************************************/
package com.jsql.view.terminal;

import java.util.UUID;

import com.jsql.view.GUIMediator;

/**
 * A terminal for SQL shell injection.
 */
@SuppressWarnings("serial")
public class SQLTerminal extends AbstractTerminal {

   /**
     * Build a SQL shell instance.
     * @param terminalID Unique identifier to discriminate beyond multiple opened terminals
     * @param shellURL URL of current shell
     * @param args User and password
     */
    public SQLTerminal(UUID terminalID, String shellURL, String... args) {
        super(terminalID, shellURL, "sql");
        this.loginPassword = args;
    }

    @Override
    void action(String cmd, UUID terminalID, String wbhPath, String... arg) {
        GUIMediator.model().rao.executeSQLShell(cmd, terminalID, wbhPath, arg[0], arg[1]);
    }
}