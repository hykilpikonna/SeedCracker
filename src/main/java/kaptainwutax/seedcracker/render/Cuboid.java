package kaptainwutax.seedcracker.render;

import net.minecraft.client.util.math.Vector4f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class Cuboid extends Renderer {

    public BlockPos start;
    public Vec3i size;
    public Vector4f color;

    private Line[] edges = new Line[12];

    public Cuboid() {
        this(BlockPos.ORIGIN, BlockPos.ORIGIN, new Vector4f(1.0f, 1.0f, 1.0f, 1.0f));
    }

    public Cuboid(BlockPos pos) {
        this(pos, new BlockPos(1, 1, 1), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f));
    }

    public Cuboid(BlockPos start, BlockPos end, Vector4f color) {
        this(start, new Vec3i(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ()), color);
    }

    public Cuboid(BlockPos start, Vec3i size, Vector4f color) {
        this.start = start;
        this.size = size;
        this.color = color;
        this.edges[0] = new Line(toVec3d(this.start), toVec3d(this.start.add(this.size.getX(), 0, 0)), this.color);
        this.edges[1] = new Line(toVec3d(this.start), toVec3d(this.start.add(0, this.size.getY(), 0)), this.color);
        this.edges[2] = new Line(toVec3d(this.start), toVec3d(this.start.add(0, 0, this.size.getZ())), this.color);
        this.edges[3] = new Line(toVec3d(this.start.add(this.size.getX(), 0, this.size.getZ())), toVec3d(this.start.add(this.size.getX(), 0, 0)), this.color);
        this.edges[4] = new Line(toVec3d(this.start.add(this.size.getX(), 0, this.size.getZ())), toVec3d(this.start.add(this.size.getX(), this.size.getY(), this.size.getZ())), this.color);
        this.edges[5] = new Line(toVec3d(this.start.add(this.size.getX(), 0, this.size.getZ())), toVec3d(this.start.add(0, 0, this.size.getZ())), this.color);
        this.edges[6] = new Line(toVec3d(this.start.add(this.size.getX(), this.size.getY(), 0)), toVec3d(this.start.add(this.size.getX(), 0, 0)), this.color);
        this.edges[7] = new Line(toVec3d(this.start.add(this.size.getX(), this.size.getY(), 0)), toVec3d(this.start.add(0, this.size.getY(), 0)), this.color);
        this.edges[8] = new Line(toVec3d(this.start.add(this.size.getX(), this.size.getY(), 0)), toVec3d(this.start.add(this.size.getX(), this.size.getY(), this.size.getZ())), this.color);
        this.edges[9] = new Line(toVec3d(this.start.add(0, this.size.getY(), this.size.getZ())), toVec3d(this.start.add(0, 0, this.size.getZ())), this.color);
        this.edges[10] = new Line(toVec3d(this.start.add(0, this.size.getY(), this.size.getZ())), toVec3d(this.start.add(0, this.size.getY(), 0)), this.color);
        this.edges[11] = new Line(toVec3d(this.start.add(0, this.size.getY(), this.size.getZ())), toVec3d(this.start.add(this.size.getX(), this.size.getY(), this.size.getZ())), this.color);
    }

    @Override
    public void render() {
        if(this.start == null || this.size == null || this.color == null || this.edges == null)return;

        for(Line edge: this.edges) {
            if(edge == null)continue;
            edge.render();
        }
    }

}
