package com.template.flows

import co.paralleluniverse.fibers.Suspendable
import net.corda.core.flows.*
import net.corda.core.utilities.ProgressTracker

import net.corda.core.flows.CollectSignaturesFlow

import net.corda.core.transactions.SignedTransaction

import java.util.stream.Collectors

import com.template.states.TemplateState
import net.corda.core.contracts.requireThat
import net.corda.core.identity.AbstractParty

import net.corda.core.contracts.Command;
import net.corda.core.identity.Party;
import net.corda.core.transactions.TransactionBuilder;
import com.template.states.IOUState;
import com.template.contracts.TemplateContract;
import net.corda.core.flows.FlowSession;
import net.corda.core.flows.FinalityFlow;

// Replace Responder's definition with:
@InitiatedBy(IOUFlow::class)
class IOUFlowResponder(private val otherPartySession: FlowSession) : FlowLogic<Unit>() {
    @Suspendable
    override fun call() {
        subFlow(ReceiveFinalityFlow(otherPartySession))
    }
}
