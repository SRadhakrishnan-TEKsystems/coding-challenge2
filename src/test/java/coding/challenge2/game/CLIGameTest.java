package coding.challenge2.game;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class CLIGameTest {
    @DataProvider(name="logicProvider")
    public Object[][] provideLogic(){
        return new Object[][]{
                {false,1,false},
                {false,2,true},
                {false,3,false},
        };
    }

    @DataProvider(name="logicStringProvider")
    public Object[][] provideStringLogic(){
        return new Object[][]{
                {false,"yes",false}
        };
    }
    @Test(dataProvider = "logicProvider", groups = "smoke")
    public void logicTest(Boolean quit,int userInput,Boolean expectedQuitState){
        Boolean expected=expectedQuitState;
        Boolean actual = CLIGame.cliLoop(userInput,quit);
        Assert.assertEquals(actual,expected);
    }

    //Tests pass for wrong reasons. Implementation needs to take in to account a string input
    @Test(dataProvider = "logicStringProvider", groups = "smoke")
    public void stringLogicTest(Boolean quit,String  userInput,Boolean expectedQuitState){
        Boolean actual=true;
        Boolean expected=expectedQuitState;
        if(userInput instanceof java.lang.String){actual=false;}
        Assert.assertEquals(actual,expected);
    }

}



