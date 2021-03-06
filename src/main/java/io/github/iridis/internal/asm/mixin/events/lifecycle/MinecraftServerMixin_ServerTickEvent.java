package io.github.iridis.internal.asm.mixin.events.lifecycle;

import java.util.function.BooleanSupplier;

import io.github.iridis.internal.events.LifecycleEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import v1_16_1.net.minecraft.server.IMinecraftServer;

import net.minecraft.server.MinecraftServer;

@Mixin (MinecraftServer.class)
public class MinecraftServerMixin_ServerTickEvent {
	@Inject(at = @At("RETURN"), method = "tick")
	protected void tick(BooleanSupplier var1, CallbackInfo info) {
		LifecycleEvents.serverTick((IMinecraftServer)this);
	}
}
