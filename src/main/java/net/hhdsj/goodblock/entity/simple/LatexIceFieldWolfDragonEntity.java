
package net.hhdsj.goodblock.entity.simple;

/*
public class LatexIceFieldWolfDragonEntity extends ChangedEntity {

	@Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        Objects.requireNonNull(attributes.getInstance(Attributes.MOVEMENT_SPEED)).setBaseValue(1.2);
        Objects.requireNonNull(attributes.getInstance(ForgeMod.SWIM_SPEED.get())).setBaseValue(0.98);
        Objects.requireNonNull(attributes.getInstance(Attributes.MAX_HEALTH)).setBaseValue(30.0);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

	@Override
    public HairStyle getDefaultHairStyle() {
        return HairStyle.SHORT_MESSY.get();
    }

    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.getColor("#00ffff");
    }

	
	public LatexIceFieldWolfDragonEntity(EntityType<? extends LatexIceFieldWolfDragonEntity> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

	@Override
    public int getTicksRequiredToFreeze() { return 480; }

	public LatexIceFieldWolfDragonEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(GoodblockModEntities.LATEX_ICE_FIELD_WOLF_DRAGON.get(), world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	public static void init() {
	}
}
*/