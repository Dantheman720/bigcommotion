package org.jboss.bigcommotion.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: danielcoughlin
 * Date: 5/6/14
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Path("/ruletest")
public class RuleTester {

    @GET
    @Path("/what")
    @Produces("application/json")
    public String test()
    {
//        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        kbuilder.add(ResourceFactory.newClassPathResource("../../../../../../../../org.jboss.bigcommotion.services/google-analtyics-import.drl"), ResourceType.DRL);
//        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
//        StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
//        try{
//            URL url = new URL("http://www.google.com");
//            ksession.execute(url);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("Test");
        return "Made it!  Did we really?";
    }

}
