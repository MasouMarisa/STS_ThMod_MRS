package ThMod_FnH.relics;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import ThMod_FnH.cards.special.Spark;
import basemod.abstracts.CustomRelic;

public class ExperimentalFamiliar extends CustomRelic {

  public static final String ID = "ExperimentalFamiliar";
  private static final String IMG = "img/relics/ExpFami.png";
  private static final String IMG_OTL = "img/relics/outline/ExpFami.png";

  public ExperimentalFamiliar() {
    super(
        ID,
        ImageMaster.loadImage(IMG),
        ImageMaster.loadImage(IMG_OTL),
        RelicTier.BOSS,
        LandingSound.FLAT
    );
  }

  public String getUpdatedDescription() {
    return DESCRIPTIONS[0];
  }

  public AbstractRelic makeCopy() {
    return new ExperimentalFamiliar();
  }

  public void atTurnStartPostDraw() {
    AbstractDungeon.actionManager.addToBottom(
        new RelicAboveCreatureAction(AbstractDungeon.player, this)
    );
    AbstractDungeon.actionManager.addToBottom(
        new MakeTempCardInHandAction(new Spark(), 1)
    );
    AbstractDungeon.actionManager.addToBottom(
        new MakeTempCardInHandAction(
            AbstractDungeon.returnTrulyRandomCard().makeCopy(),
            1
        )
    );
  }
}